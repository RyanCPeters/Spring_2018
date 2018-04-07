A list of some helpful Reference Links
===

### ToC
---

1. [Using Java with Nvidia GPU's (cuda)]



---
# [Using Java with Nvidia GPU's (cuda)](https://stackoverflow.com/a/22868938/7412747)

#### Original Question

I'm working on a business project that is done in java and needs huge computation power to computer business markets. Simple math but with huge amount of data.

We ordered some cuda gpu's to try it with and since Java is not supported by cuda, Im wondering where to start with. Should I build a JNI interface? Should I use JCUDA or is there other ways to go with this?

I dont have experience in this field and I would like if someone could direct me to something so I can start researching and learning.


---
## [Marco13's Answer](https://stackoverflow.com/users/3182664/marco13)
---

First of all, you should be aware of the fact that CUDA will not automagically make computations faster. On the one hand, because GPU programming is an art, and it can be very, very challenging to get it *right*. On the other hand, because GPUs are well-suited only for certain *kinds* of computations.

This may sound confusing, because you can basically compute *anything* on the GPU. The key point is, of course, whether you will achieve a good speedup or not. The most important classification here is whether a problem is **task parallel** or **data parallel**. The first one refers, roughly speaking, to problems where several threads are working on their own tasks, more or less independently. The second one refers to problems where *many* threads are *all doing the same* - but on different parts of the data. 

The latter is the kind of problem that GPUs are good at: They have *many* cores, and all the cores do the same, but operate on different parts of the input data. 

You mentioned that you have "simple math but with huge amount of data". Although this may sound like a perfectly data-parallel problem and thus like it was well-suited for a GPU, there is another aspect to consider: GPUs are ridiculously fast in terms of theoretical computational power (FLOPS, Floating Point Operations Per Second). But they are often throttled down by the memory bandwidth.

This leads to another classification of problems. Namely whether problems are **memory bound** or **compute bound**. 

The first one refers to problems where the number of instructions that are done for each data element is low. For example, consider a parallel vector addition: You'll have to *read* two data elements, then perform a single addition, and then *write* the sum into the result vector. You will not see a speedup when doing this on the GPU, because the single addition does not compensate for the efforts of reading/writing the memory. 

The second term, "compute bound", refers to problems where the number of instructions is high compared to the number of memory reads/writes. For example, consider a matrix multiplication: The number of instructions will be O(n^3) when n is the size of the matrix. In this case, one can expect that the GPU will outperform a CPU at a certain matrix size. Another example could be when many complex trigonometric computations (sine/cosine etc) are performed on "few" data elements. 

As a rule of thumb: You can assume that reading/writing one data element from the "main" GPU memory has a latency of about 500 instructions....

Therefore, another key point for the performance of GPUs is **data locality**: If you have to read or write data (and in most cases, you will have to ;-)), then you should make sure that the data is kept as close as possible to the GPU cores. GPUs thus have certain memory areas (referred to as "local memory" or "shared memory") that usually is only a few KB in size, but particularly efficient for data that is about to be involved in a computation.

So to emphasize this again: GPU programming is an art, that is only remotely related to parallel programming on the CPU. Things like Threads in Java, with all the concurrency infrastructure like `ThreadPoolExecutors`, `ForkJoinPools` etc. might give the impression that you just have to split your work somehow and distribute it among several processors. On the GPU, you may encounter challenges on a much lower level: Occupancy, register pressure, shared memory pressure, memory coalescing ... just to name a few.  

However, when you have a data-parallel, compute-bound problem to solve, the GPU is the way to go. 

---


## Some remarks

Your specifically asked for CUDA. But I'd strongly recommend you to also have a look at OpenCL. It has several advantages. First of all, it's an vendor-independent, open industry standard, and there are implementations of OpenCL by AMD, Apple, Intel and NVIDIA. Additionally, there is a much broader support for OpenCL in the Java world. The only case where I'd rather settle for CUDA is when you want to use the CUDA runtime libraries, like CUFFT for FFT or CUBLAS for BLAS (Matrix/Vector operations). Although there are approaches for providing similar libraries for OpenCL, they can not directly be used from Java side, unless you create your own JNI bindings for these libraries. 

---

You might also find it interesting to hear that in October 2012, the OpenJDK HotSpot group started the project "Sumatra": http://openjdk.java.net/projects/sumatra/ . The goal of this project is to provide GPU support *directly* in the JVM, with support from the JIT. The current status and first results can be seen in their mailing list at http://mail.openjdk.java.net/mailman/listinfo/sumatra-dev 

---


However, a while ago, I collected some resources related to "Java on the GPU" in general. I'll summarize these again here, in no particular order.

(**Disclaimer**: I'm the author of http://jcuda.org/ and http://jocl.org/ )


## (Byte)code translation and OpenCL code generation: ##

https://github.com/aparapi/aparapi : An open-source library that is created and actively maintained by AMD. In a special "Kernel" class, one can override a specific method which should be executed in parallel. The byte code of this method is loaded at runtime using an own bytecode reader. The code is translated into OpenCL code, which is then compiled using the OpenCL compiler. The result can then be executed on the OpenCL device, which may be a GPU or a CPU. If the compilation into OpenCL is not possible (or no OpenCL is available), the code will still be executed in parallel, using a Thread Pool.

https://github.com/pcpratts/rootbeer1 : An open-source library for converting parts of Java into CUDA programs. It offers dedicated interfaces that may be implemented to indicate that a certain class should be executed on the GPU. In contrast to Aparapi, it tries to automatically serialize the "relevant" data (that is, the complete relevant part of the object graph!) into a representation that is suitable for the GPU.

https://code.google.com/archive/p/java-gpu/ : A library for translating annotated Java code (with some limitations) into CUDA code, which is then compiled into a library that executes the code on the GPU. The Library was developed in the context of a PhD thesis, which contains profound background information about the translation process.

https://github.com/ochafik/ScalaCL : Scala bindings for OpenCL. Allows special Scala collections to be processed in parallel with OpenCL. The functions that are called on the elements of the collections can be usual Scala functions (with some limitations) which are then translated into OpenCL kernels.

## Language extensions ##

http://www.ateji.com/px/index.html : A language extension for Java that allows parallel constructs (e.g. parallel for loops, OpenMP style) which are then executed on the GPU with OpenCL. Unfortunately, this very promising project is no longer maintained. 


http://www.habanero.rice.edu/Publications.html (JCUDA) : A library that can translate special Java Code (called JCUDA code) into Java- and CUDA-C code, which can then be compiled and executed on the GPU. However, the library does not seem to be publicly available.

https://www2.informatik.uni-erlangen.de/EN/research/JavaOpenMP/index.html : Java language extension for for OpenMP constructs, with a CUDA backend

## Java OpenCL/CUDA binding libraries ##

https://github.com/ochafik/JavaCL : Java bindings for OpenCL: An object-oriented OpenCL library, based on auto-generated low-level bindings

http://jogamp.org/jocl/www/ : Java bindings for OpenCL: An object-oriented OpenCL library, based on auto-generated low-level bindings

http://www.lwjgl.org/ : Java bindings for OpenCL: Auto-generated low-level bindings and object-oriented convenience classes

http://jocl.org/ : Java bindings for OpenCL: Low-level bindings that are a 1:1 mapping of the original OpenCL API

http://jcuda.org/ : Java bindings for CUDA: Low-level bindings that are a 1:1 mapping of the original CUDA API

## Miscellaneous ##

http://sourceforge.net/projects/jopencl/ : Java bindings for OpenCL. Seem to be no longer maintained since 2010

http://www.hoopoe-cloud.com/ : Java bindings for CUDA. Seem to be no longer maintained


---

