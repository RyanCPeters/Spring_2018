package com.Statements;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractProposition
  implements Comparable
{
  
  public static int nullCount = 0;
  
  /**
   <pre>
   This contains the exact form of the propositional statement and it's
   constituent parts as appropriate for this instance's level in the nested
   hierarchy.
   </pre>
   */
  private
  String statement;
  private
  List<AbstractProposition> statementComponents;
  
  ObservableList<AbstractProposition> observedStatementsList;
  
  
  
  /**
   
   @param statement the string representation of the
   */
  AbstractProposition( String statement ) {
    this.statement = statement;
    statementComponents = new ArrayList<>();
    observedStatementsList = FXCollections.observableList( statementComponents );
    observedStatementsList.addListener( new ListChangeListener<AbstractProposition>() {
        @Override public
        void onChanged( Change<? extends AbstractProposition> c ) {
            // TODO: 4/29/2018 Add listeners to this list's listener references
        }
      }
    );
    
  }
  
  public
  String getStatement() {
    
    return statement;
  }
  
  /**
   <pre>
   
   @return
   
   </pre>
   */
  public
  ObservableList<AbstractProposition> getObservedStatementsList(){
    return observedStatementsList;
  }
  
  protected
  void setStatement( String statement ) {
    
    this.statement = statement;
  }
  
  public
  void updateProposition( String statement ) {
    this.statement = statement;
    observedStatementsList.get( 0 );
    
  }
}

// The comment lines bellow serve as a reference to a template I am following as
// an example of how I can relate my ObservableValue calls.

/*
////////////////////////////////////////////////////////////////////////////////
  public
  interface Issue
  {

   public static
   enum IssueStatus
   {
     NEW, OPENED, FIXED, CLOSED
   }

   public
   String getId();

   public
   String getProjectName();

   public
   IssueStatus getStatus();

   public
   String getSynopsis();

   public
   String getDescription();
  }

////////////////////////////////////////////////////////////////////////////////
  import javafx.beans.value.ObservableValue;

  public
  interface ObservableIssue
    extends Issue
  {

   public
   ObservableValue<String> idProperty();

   public
   ObservableValue<String> projectNameProperty();

   public
   ObservableValue<IssueStatus> statusProperty();

   public
   ObservableValue<String> synopsisProperty();

   public
   ObservableValue<String> descriptionProperty();
  }

////////////////////////////////////////////////////////////////////////////////
  import issuetrackinglite.model.Issue.IssueStatus;
  import javafx.collections.ObservableList;
  public
  interface TrackingService
  {

   ObservableList<String> getIssueIds( String projectName );

   ObservableList<String> getProjectNames();

   ObservableIssue getIssue( String tickectId );

   ObservableIssue createIssueFor( String projectName );

   void deleteIssue( String issueId );

   void saveIssue(
     String issueId, IssueStatus status,
      String synopsis, String description );
  }
////////////////////////////////////////////////////////////////////////////////
*/
