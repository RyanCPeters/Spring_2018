/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle Corporation nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package examples_references.issuetrackinglite.model;

import examples_references.issuetrackinglite.model.Issue.IssueStatus;
import javafx.collections.ObservableList;

/**
 public interface TrackingService <br>
 <pre>
    An interface that provides method signatures for:
    
    + getters for lists
        * getting lists of tracked Issue IDs
        * getting lists of project names
    + getters for specific tracked issues
        * getting Issue details.
    + setter for new Issues per projectName
    + deleting issues according to issueID value
    + a method for saving/updating issues on a per project basis
 
    
    abstract Methods signatures :
    
    ObservableList<String> getIssueIds( String projectName );
 
    ObservableList<String> getProjectNames();
 
    ObservableIssue getIssue( String tickectId );
 
    ObservableIssue createIssueFor( String projectName );
 
    void deleteIssue( String issueId );
 
    void saveIssue( String issueId, IssueStatus status,
                    String synopsis, String description );
 </pre>
 */
public interface TrackingService {

    ObservableList<String> getIssueIds( String projectName );
    ObservableList<String> getProjectNames();
    ObservableIssue getIssue( String tickectId );
    ObservableIssue createIssueFor( String projectName );
    void deleteIssue( String issueId );
    void saveIssue(
        String issueId, IssueStatus status,
        String synopsis, String description );
}
