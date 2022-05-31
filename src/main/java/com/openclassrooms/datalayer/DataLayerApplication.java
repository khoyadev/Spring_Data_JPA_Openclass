package com.openclassrooms.datalayer;
 
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.openclassrooms.datalayer.model.Category;
import com.openclassrooms.datalayer.model.Comment;
import com.openclassrooms.datalayer.model.Product;

import com.openclassrooms.datalayer.service.CategoryService;
import com.openclassrooms.datalayer.service.CommentService;
import com.openclassrooms.datalayer.service.ProductService;

 
@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner {
 
	@Autowired
	private ProductService productService;
	@Autowired
    private CategoryService categoryService;
	@Autowired
	private CommentService commentService;
	
	public static void main(String[] args) {
		SpringApplication.run(DataLayerApplication.class, args);
	}
 
    @Override
    @Transactional
    public void run(String... args) throws Exception {
    	//Rechercher category par le nom de la catégorie 
    	Iterable<Category> searchResultsNameCategorie = categoryService.getCategoriesfindByName("Standard");
    	searchResultsNameCategorie.forEach(categoty ->System.out.println(categoty.getCategoryId()));
    	
    	//Rechercher category par le nom d’un produit de la catégorie.
    	searchResultsNameCategorie = categoryService.getCategoryByProductName("AssuranceTousRisquesJeunes");	
    	searchResultsNameCategorie.forEach(categoty ->System.out.println(categoty.getName()));
    	//Rechercher un produit par un nom
		Iterable<Product> searchResults = productService.getProductsByName("AssuranceTousRisques");
		searchResults.forEach(product -> System.out.println(product.getProductId()));

		searchResults = productService.getProductByCategoriesName("Standard");
		searchResults.forEach(product -> System.out.println(product.getName()));
		
//		//Rechercher un produit dont le coût est inférieur à 1 000 €.
		searchResults = productService.getcostProduct(1000);
		searchResults.forEach(product -> System.out.println(product.getName()));
//		
//		//La recherche des commentaires dont le contenu contient le mot “déçu”
		Iterable<Comment> searchResultsComment = commentService.getfindByContentContaining("déçu");
		searchResultsComment.forEach(comment -> System.out.println(comment.getContent()));
		
    	//Supprimer
    	//categoryService.deleteCategorie(5);
    	
//    	METTRE A JOUT 
//		Product existingProduct = productService.getProductById(1).get();
//		System.out.println(existingProduct.getCost());
//		
//		existingProduct.setCost(3000);
//		productService.addProduct(existingProduct);
//		
//		existingProduct = productService.getProductById(1).get();
//		System.out.println(existingProduct.getCost());

		
    	// AJOUT COMPLET DE categorie a commentaire
//		categoryService.getCategories().forEach(
//				category -> System.out.println(category.getName()));
//		
//		Category newCategory = new Category();
//		newCategory.setName("Promotion");
//		
//		newCategory = categoryService.saveCategorie(newCategory);
//		
//		categoryService.getCategories().forEach(
//				category -> System.out.println(category.getName()));
//		
//		Product newProduct = new Product();
//		newProduct.setName("AssuranceAuTiersFidelite");
//		newProduct.setDescription("Les garanties de l'assurance au tiers à un prix moindre grâce à votre fidélité!");
//		newProduct.setCost(1100);
//		
//		newCategory.addProduct(newProduct);
//		
//		newProduct = productService.addProduct(newProduct);
//		
//		productService.getProducts().forEach(
//				product -> System.out.println(product.getName()));
//
//		newProduct.getCategories().forEach(
//				category -> System.out.println(category.getName()));
//		
//		Comment newComment = new Comment();
//		newComment.setContent("Assurance extraordinaire!");
//		newProduct.addComment(newComment);
//
//		commentService.addComment(newComment);
    	
    	/////////////////////////////////////////////////////////////
    	//il est possible de sauvegarder plusieurs nouveaux éléments simultanément, comme dans l’exemple ci-dessous où l’on sauvegarde un nouveau produit et une nouvelle catégorie en même temps :
//    	Category newCategory = new Category();
//    	newCategory.setName("-25ans");
//    		
//    	Product newProduct = new Product();
//    	newProduct.setName("AssuranceAuTiers-25ans");
//    	newProduct.setDescription("Assurance au tiers réservée aux conducteurs de -25 ans.");
//    	newProduct.setCost(2000);
//    		
//    	newCategory.addProduct(newProduct);
//    	categoryService.saveCategorie(newCategory);
    	
    	////////////////////////////////////////////////////////////////
    	//ajouter un commentaire a partir d'un produit grace a méthode utilitaire addComment de la classe Product !	
//    	Product productAssuranceAuTiers = productService.getProductById(1).get();	
//    	Comment newComment = new Comment();
//    	newComment.setContent("Assurance peu intéressante.");
//    	productAssuranceAuTiers.addComment(newComment);

    	//////////////////////////////////////////////////////////////////////////
//    	categoryService.getCategories().forEach(
//				category -> System.out.println(category.getName()));
//		
//		Category newCategory = new Category();
//		newCategory.setName("PromotionFidelite");
//		
//		newCategory = categoryService.saveCategorie(newCategory);
//		
//		categoryService.getCategories().forEach(
//				category -> System.out.println(category.getName()));
//		
//		Product newProduct = new Product();
//		newProduct.setName("AssuranceAuTiersFidelite");
//		newProduct.setDescription("Les garanties de l'assurance au tiers à un prix moindre grâce à votre fidélité!");
//		newProduct.setCost(1100);
//		
//		newCategory.addProduct(newProduct);
//		
//		newProduct = productService.addProduct(newProduct);
//		
//		productService.getProducts().forEach(
//				product -> System.out.println(product.getName()));
// 
//		newProduct.getCategories().forEach(
//				category -> System.out.println(category.getName()));
    	
//    	
//    	Product newProduct = new Product();
//    	productService.getProducts().forEach(
//    			product -> System.out.println(product.getName()));
//    	
//    	newProduct.setName("Assurance");
//    	newProduct.setCost(1000);
//    	newProduct.setDescription("Assurance simple");
//    	
//    	productService.addProduct(newProduct);
//    	
//    	productService.getProducts().forEach(
//    			product -> System.out.println(product.getName()));
    	
    	// Ajout Categorie
 //   	Category addCategory = new Category();
//    	
//    	categoryService.getCategories().forEach(
//				category -> System.out.println(category.getName()));	
//    	
//    	addCategory.setName("Promotion");
//    	categoryService.saveCategorie(addCategory);
//    	
//    	categoryService.getCategories().forEach(
//				category -> System.out.println(category.getName()));
    	/////////////////////////////////////////////////////////////////////////////////////////
    	
    	// Affichage des donnees
    	
//    	Optional<Product> optProduct = productService.getProductById(1);
//		Product productId1 = optProduct.get();
//		
//		System.out.println(productId1.getName());
//
//		productId1.getComments().forEach(
//				comment -> System.out.println(comment.getContent()));	
//		
//		productId1.getCategories().forEach(
//				category -> System.out.println(category.getName())); 
//		
//		Optional<Category> optCategory = categoryService.getCategoryById(1);
//		Category categoryId2 = optCategory.get();
//		
// 
//		//System.out.println(categoryId2.getName());
//		
//		categoryId2.getProducts().forEach(
//				produit -> System.out.println(produit.getName()));	
//		 	
//		Optional<Comment> optComment = commentService.getCommentById(1);
//		Comment commentId1 = optComment.get();
//		
//		System.out.println(commentId1.getContent());
//		System.out.println(commentId1.getProduct().getName());
    }  
 
}
