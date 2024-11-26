package numpyninja.dsalgo.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import numpyninja.dsalgo.constants.Constants;

public class Tree {
	
	public WebDriver tdriver;
	Constants constants=new Constants();

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
	
	
	
	public boolean result=false;
	
	public void click_Overview_of_trees() {OVERVIEW_OF_TREES_LK.click();}
	public void click_Terminoloies() {TERMINOLOGIES_LK.click();}
	public void click_TypesOfTrees() {TYPES_OF_TREES_LK.click();}
	public void click_TreeTraversals() {TREE_TRAVERSALS_LK.click();}
	public void click_TraversalsIllustrations(){TRAVERSALS_ILLUSTRATION_LK.click();}
	public void click_BinaryTree() {BINARY_TREE_LK.click();}
	
	public void click_TypesOfBinaryTree() {
		System.out.println("I entered click type of Binary Tree");
		TYPES_OF_BINARY_TREE_LK.click();
		System.out.println("I  clicked type of Binary Tree");
	}
	
	public void click_ImplementationInPython() {IMPLEMENTATION_IN_PYTHON_LK.click();}
	public void click_BinaryTreeTraversals() {BINARY_TREE_TRAVERSALS.click();}
	public void click_ImplementationOfBinaryTrees() {IMPLEMENTATION_OF_BINARY_TREES.click();}
	public void click_ApplicationsofBinaryTree() {APPLICATIONS_OF_BINARY_TREE_LK.click();}
	
	public void click_BinarySearchTree() {
		System.out.println("I entered click type of Binary Search Tree");
		BINARY_SEARCH_TREE_LK.click();
		System.out.println("I  clicked type of Binary Search Tree\"");}
	
	public void click_ImplementationOfBST() {
		System.out.println("I entered click type of Implementation of Binary ST");
		IMPLEMENTATION_OF_BST_LK.click();
		System.out.println("I  clicked type of Implementation of Binary ST");	
	}
	
	public void click_PractiseQuestions() {PRACTISE_QUESTIONS.click();}
	
	public boolean Validate_OverviewOfTreePage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(constants.OVERVIEW_OF_TREE_URL);
				return result;}
	public boolean Validate_TerminologiesPage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(constants.TERMINOLOGIES_URL);
		return result;}
	public boolean Validate_TypesofTreesPage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(constants.TYPES_OF_TREES_URL);
		return result;}
	public boolean Validate_TreeTraversalsPage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(constants.TREE_TRAVERSALS_URL);
		return result;}
	public boolean Validate_TraversalsIllustrationPage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(constants.TRAVERSALS_ILLUSTRATION_URL);
		
		return result;
		}
	public boolean Validate_BinaryTreePage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(constants.BINARY_TREE_URL);
		return result;}
	public boolean Validate_TypesOfBinaryTreePage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(constants.TYPES_OF_BINARY_TREE_URL);
		return result;}
	public boolean Validate_ImplementationInPythonPage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(constants.IMPLEMENTATION_IN_PYTHON_URL);
		return result;}
	public boolean Validate_BinaryTreeTraversalsPage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(constants.BINARY_TREE_TRAVERSALS_URL);
		return result;}
	public boolean Validate_ImplementationOfBinaryTreesPage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(constants.IMPLEMENTATION_OF_BINARY_TREES_URL);
		return result;}
	public boolean Validate_ApplicationOfBinaryTreesPage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(constants.APPLICATIONS_OF_BINARY_TREES_URL);
		return result;}
	public boolean Validate_BinarySearchTreePage() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(constants.BINARY_SEARCH_TREE_URL);
		return result;}
	public boolean Validate_ImplementationOfBST() {
		result = tdriver.getCurrentUrl().equalsIgnoreCase(constants.IMPLEMENTATION_OF_BST_URL);
		return result;}
	
	

}
