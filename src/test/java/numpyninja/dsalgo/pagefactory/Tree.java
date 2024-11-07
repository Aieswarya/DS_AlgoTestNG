package numpyninja.dsalgo.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tree {
	
	public WebDriver tdriver;

	public Tree(WebDriver rdriver) {
		tdriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[@href='overview-of-trees']")
	@CacheLookup
	private WebElement OVERVIEW_OF_TREES_LK;
	@FindBy(xpath="//a[@href='terminologies']")
	@CacheLookup
	private WebElement TERMINOLOGIES_LK;
	@FindBy(xpath="//a[@href='types-of-trees']")
	@CacheLookup
	private WebElement TYPES_OF_TREES_LK;
	@FindBy(xpath="//a[@href='tree-traversals']")
	@CacheLookup
	private WebElement TREE_TRAVERSALS_LK;
	@FindBy(xpath="//a[@href='traversals-illustration']")
	@CacheLookup
	private WebElement TRAVERSALS_ILLUSTRATION_LK;
	@FindBy(xpath="//a[@href='binary-trees']")
	@CacheLookup
	private WebElement BINARY_TREE_LK;
	@FindBy(xpath="//a[@href='types-of-binary-trees']")
	@CacheLookup
	private WebElement TYPES_OF_BINARY_TREE_LK;
	@FindBy(xpath="//a[@href='implementation-in-python']")
	@CacheLookup
	private WebElement IMPLEMENTATION_IN_PYTHON_LK;
	@FindBy(xpath="//a[@href='binary-tree-traversals']")
	@CacheLookup
	private WebElement BINARY_TREE_TRAVERSALS;
	@FindBy(xpath="//a[@href='implementation-of-binary-trees']")
	@CacheLookup
	private WebElement IMPLEMENTATION_OF_BINARY_TREES;
	@FindBy(xpath="//a[@href='applications-of-binary-trees']")
	@CacheLookup
	private WebElement APPLICATIONS_OF_BINARY_TREE_LK;
	@FindBy(xpath="//a[@href='binary-search-trees']")
	@CacheLookup
	private WebElement BINARY_SEARCH_TREE_LK;
	@FindBy(xpath="//a[@href='implementation-of-bst']")
	@CacheLookup
	private WebElement IMPLEMENTATION_OF_BST_LK;
	@FindBy(xpath="//a[@href='/tree/practice']")
	@CacheLookup
	private WebElement PRACTISE_QUESTIONS;
	
	private String OVERVIEW_OF_TREE_URL="https://dsportalapp.herokuapp.com/tree/overview-of-trees/";
	private String TERMINOLOGIES_URL="https://dsportalapp.herokuapp.com/tree/terminologies/";
	private String TYPES_OF_TREES_URL="https://dsportalapp.herokuapp.com/tree/types-of-trees/";
	private String TREE_TRAVERSALS_URL="https://dsportalapp.herokuapp.com/tree/tree-traversals/";
	private String TRAVERSALS_ILLUSTRATION_URL="https://dsportalapp.herokuapp.com/tree/traversals-illustration/";
	private String BINARY_TREE_URL="https://dsportalapp.herokuapp.com/tree/binary-trees/";
	private String TYPES_OF_BINARY_TREE_URL="https://dsportalapp.herokuapp.com/tree/types-of-binary-trees/";
	private String IMPLEMENTATION_IN_PYTHON_URL="https://dsportalapp.herokuapp.com/tree/implementation-in-python/";
	private String BINARY_TREE_TRAVERSALS_URL="https://dsportalapp.herokuapp.com/tree/binary-tree-traversals/";
	private String IMPLEMENTATION_OF_BINARY_TREES_URL="https://dsportalapp.herokuapp.com/tree/implementation-of-binary-trees/";
	private String APPLICATIONS_OF_BINARY_TREES_URL="https://dsportalapp.herokuapp.com/tree/applications-of-binary-trees/";
	private String BINARY_SEARCH_TREE_URL="https://dsportalapp.herokuapp.com/tree/binary-search-trees/";
	private String IMPLEMENTATION_OF_BST_URL="https://dsportalapp.herokuapp.com/tree/implementation-of-bst/";
	
	public boolean result=false;
	
	public void click_Overview_of_trees() {OVERVIEW_OF_TREES_LK.click();}
	public void click_Terminoloies() {TERMINOLOGIES_LK.click();}
	public void click_TypesOfTrees() {TYPES_OF_TREES_LK.click();}
	public void click_TreeTraversals() {TREE_TRAVERSALS_LK.click();}
	public void click_TraversalsIllustrations(){TRAVERSALS_ILLUSTRATION_LK.click();}
	public void click_BinaryTree() {BINARY_TREE_LK.click();}
	public void click_TypesOfBinaryTree() {TYPES_OF_BINARY_TREE_LK.click();}
	public void click_ImplementationInPython() {IMPLEMENTATION_IN_PYTHON_LK.click();}
	public void click_BinaryTreeTraversals() {BINARY_TREE_TRAVERSALS.click();}
	public void click_ImplementationOfBinaryTrees() {IMPLEMENTATION_OF_BINARY_TREES.click();}
	public void click_ApplicationsofBinaryTree() {APPLICATIONS_OF_BINARY_TREE_LK.click();}
	public void click_BinarySearchTree() {BINARY_SEARCH_TREE_LK.click();}
	public void click_ImplementationOfBST() {IMPLEMENTATION_OF_BST_LK.click();}
	public void click_PractiseQuestions() {PRACTISE_QUESTIONS.click();}
	
	public boolean Validate_OverviewOfTreePage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(OVERVIEW_OF_TREE_URL);
				return result;}
	public boolean Validate_TerminologiesPage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(TERMINOLOGIES_URL);
		return result;}
	public boolean Validate_TypesofTreesPage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(TYPES_OF_TREES_URL);
		return result;}
	public boolean Validate_TreeTraversalsPage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(TREE_TRAVERSALS_URL);
		return result;}
	public boolean Validate_TraversalsIllustrationPage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(TRAVERSALS_ILLUSTRATION_URL);
		System.out.println("Inside then of Tree Traversals"+ result);
		System.out.println("Inside then of Tree Traversals"+ tdriver.getCurrentUrl());
		
		return result;
		}
	public boolean Validate_BinaryTreePage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(BINARY_TREE_URL);
		return result;}
	public boolean Validate_TypesOfBinaryTreePage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(TYPES_OF_BINARY_TREE_URL);
		return result;}
	public boolean Validate_ImplementationInPythonPage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(IMPLEMENTATION_IN_PYTHON_URL);
		return result;}
	public boolean Validate_BinaryTreeTraversalsPage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(BINARY_TREE_TRAVERSALS_URL);
		return result;}
	public boolean Validate_ImplementationOfBinaryTreesPage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(IMPLEMENTATION_OF_BINARY_TREES_URL);
		return result;}
	public boolean Validate_ApplicationOfBinaryTreesPage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(APPLICATIONS_OF_BINARY_TREES_URL);
		return result;}
	public boolean Validate_BinarySearchTreePage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(BINARY_SEARCH_TREE_URL);
		return result;}
	public boolean Validate_ImplementationOfBST() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(IMPLEMENTATION_OF_BST_URL);
		return result;}
	
	

}
