package guiElements;

import java.net.URL;
import java.util.ResourceBundle;

import com.Statements.AbstractProposition;
import com.Statements.Proposition;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 Sample Skeleton for 'TTableFXML.fxml' Controller Class
 */
public
class TTableFXController
{
  
  @FXML // fx:id="newStatementBtn"
  public Button newStatementBtn;
  
  @FXML // fx:id="newParameterBtn"
  public Button newParameterBtn;
  
  @FXML // fx:id="formCompoundBtn"
  public Button formCompoundBtn;
  
  @FXML // fx:id="baseLevelHBox"
  private HBox baseLevelHBox;
  
  @FXML // ResourceBundle that was given to the FXMLLoader
  private ResourceBundle resources;
  
  @FXML // URL location of the FXML file that was given to the FXMLLoader
  private URL location;
  
  @FXML // fx:id="samplePThenQColumn"
  private TableColumn<?,?> samplePThenQColumn; // Value injected by FXMLLoader
  
  @FXML // fx:id="sampleQColumn"
  private TableColumn<?,?> sampleQColumn; // Value injected by FXMLLoader
  
  @FXML // fx:id="samplePColumn"
  private TableColumn<?,?> samplePColumn; // Value injected by FXMLLoader
  
  @FXML // fx:id="baseSplitPane"
  private SplitPane baseSplitPane; // Value injected by FXMLLoader
  
  @FXML // fx:id="statementBuildingAnchor"
  private AnchorPane statementBuildingAnchor; // Value injected by FXMLLoader
  
  @FXML // fx:id="tableBaseAnchorPane"
  private AnchorPane tableBaseAnchorPane; // Value injected by FXMLLoader
  
  @FXML // fx:id="computedStatementDemoLabel"
  private Label computedStatementDemoLabel; // Value injected by FXMLLoader
  
  @FXML // fx:id="treeViewController"
  private TreeView<Proposition> treeViewController; // Value injected by FXMLLoader
  
  @FXML // fx:id="computeToTable"
  private Button computeToTable; // Value injected by FXMLLoader
  
  @FXML // fx:id="treeAnchorPane"
  private AnchorPane treeAnchorPane; // Value injected by FXMLLoader
  
  @FXML // fx:id="baseAnchorPane"
  private AnchorPane baseAnchorPane; // Value injected by FXMLLoader
  
  @FXML // fx:id="tableViewController"
  private TableView<?> tableViewController; // Value injected by FXMLLoader
  
  @FXML // fx:id="computableStatementLabel"
  private Label computableStatementLabel; // Value injected by FXMLLoader
  
  @FXML // This method is called by the FXMLLoader when initialization is complete
  public void initialize() {
  
    Proposition initProp = new Proposition( "p -> q" );
    
    initProp.expandStatement( "", "p" );
    initProp.expandStatement( "", "q" );
    
    TreeItem<Proposition> root = new TreeItem<>(initProp);
    
    for(AbstractProposition p : initProp.getObservedStatementsList()){
      TreeItem<Proposition> propLeaf = new TreeItem<>( (Proposition)p);
      root.getChildren().add( propLeaf );
    }
    treeViewController.setRoot( root );
    treeViewController.setEditable( true );
    treeViewController.setCellFactory( p -> new TextFieldTreeCellImpl() );
  
  
    assert samplePThenQColumn !=
           null : "fx:id=\"samplePThenQColumn\" was not injected: check your FXML file 'TTableFXML.fxml'.";
    assert sampleQColumn !=
           null : "fx:id=\"sampleQColumn\" was not injected: check your FXML file 'TTableFXML.fxml'.";
    assert samplePColumn !=
           null : "fx:id=\"samplePColumn\" was not injected: check your FXML file 'TTableFXML.fxml'.";
    assert baseSplitPane !=
           null : "fx:id=\"baseSplitPane\" was not injected: check your FXML file 'TTableFXML.fxml'.";
    assert statementBuildingAnchor !=
           null : "fx:id=\"statementBuildingAnchor\" was not injected: check your FXML file 'TTableFXML.fxml'.";
    assert tableBaseAnchorPane !=
           null : "fx:id=\"tableBaseAnchorPane\" was not injected: check your FXML file 'TTableFXML.fxml'.";
    assert computedStatementDemoLabel !=
           null : "fx:id=\"computedStatementDemoLabel\" was not injected: check your FXML file 'TTableFXML.fxml'.";
    assert treeViewController !=
           null : "fx:id=\"treeViewController\" was not injected: check your FXML file 'TTableFXML.fxml'.";
    assert computeToTable !=
           null : "fx:id=\"computeToTable\" was not injected: check your FXML file 'TTableFXML.fxml'.";
    assert treeAnchorPane !=
           null : "fx:id=\"treeAnchorPane\" was not injected: check your FXML file 'TTableFXML.fxml'.";
    assert baseAnchorPane !=
           null : "fx:id=\"baseAnchorPane\" was not injected: check your FXML file 'TTableFXML.fxml'.";
    assert tableViewController !=
           null : "fx:id=\"tableViewController\" was not injected: check your FXML file 'TTableFXML.fxml'.";
    assert computableStatementLabel !=
           null : "fx:id=\"computableStatementLabel\" was not injected: check your FXML file 'TTableFXML.fxml'.";
    
    
    
  }
  
  private final
  class TextFieldTreeCellImpl
    extends TreeCell<Proposition>
  {
  
    private TextField textField;
    
    private ContextMenu addMenu = new ContextMenu();
    
    public
    TextFieldTreeCellImpl() {
      
      MenuItem addMenuItem = new MenuItem( "Add Propositional Statement" );
      addMenu.getItems().add( addMenuItem );
      addMenuItem.setOnAction( t ->
                               {
                                 TreeItem<Proposition> newProp = new TreeItem<>( new Proposition() );
                                 getTreeItem().getChildren().add( newProp );
                               } );
    }
    
    @Override
    public
    void startEdit() {
      
      super.startEdit();
      
      if( textField == null ) {
        createTextField();
      }
      setText( null );
      setGraphic( textField );
      textField.selectAll();
    }
    
    @Override
    public
    void cancelEdit() {
  
      super.cancelEdit();
      
      setText( getItem().toString() );
      setGraphic( getTreeItem().getGraphic() );
    }
    
    @Override
    public
    void updateItem( Proposition item, boolean empty ) {
  
      super.updateItem( item, empty );
      
      if( empty ) {
        setText( null );
        setGraphic( null );
      }
      else {
        if( isEditing() ) {
          if( textField != null ) {
            textField.setText( getString() );
          }
          setText( null );
          setGraphic( textField );
        }
        else {
          setText( getString() );
          setGraphic( getTreeItem().getGraphic() );
          if( ! getTreeItem().isLeaf() && getTreeItem().getParent() != null ) {
            setContextMenu( addMenu );
          }
        }
      }
    }
    
    private
    void createTextField() {
      
      textField = new TextField( getString() );
      textField.setOnKeyReleased(
        t ->
        {
          if( t.getCode() == KeyCode.ENTER ){
            getItem().updateProposition( textField.getText() );
            commitEdit( getItem() );
          }else if( t.getCode() == KeyCode.ESCAPE ) {
            cancelEdit();
          }
        } );
      
    }
    
    private
    String getString() {
      
      return getItem() == null? "" : getItem().toString();
    }
  } // ends private final class TextFieldTreeCellImpl extends TreeCell<String>
}
