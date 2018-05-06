package com.fast.cosmin.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@DefaultUrl("https://fasttrackit.org/selenium-test/catalogsearch/result/")
public class SearchResultPage extends PageObject {

    @FindBy(css = ".page-title")
    private WebElementFacade pageTitle;
    @FindBy(css = ".toolbar-bottom .limiter option:nth-child(1)")
    private WebElementFacade numberOfProductsSelectedToBeDisplayedOnPage;
    @FindBy(css = ".toolbar-bottom .amount")
    private WebElementFacade totalNumberOfProducts;
    @FindBy(css = ".category-products .products-grid .item")
    private List<WebElementFacade> productList;
    @FindBy(css = ".btn-cart")
    private WebElementFacade buttonAddToCart;
    @FindBy(css = ".product-info .actions .button ")
    private WebElementFacade buttonViewDetails;

    private int numberOfProductsDisplayedOnPage;
    private int numberOfProducts;
    private int totalNumberOfPages;
    private int productsOnLastPage;
    private int randomPageNumber;
    private int randomIndexOfProduct;
    public String selectedProductName;



//Citeste textul de pe elementul "numberOfProductsSelectedToBeDisplayedOnPage". Elminina spatiile goale. Citeste valoarea si salveaz-o ca int.
    public void readNumberOfProductsDisplayed(){
        String textFromElement = numberOfProductsSelectedToBeDisplayedOnPage.getText().trim();
        numberOfProductsDisplayedOnPage = Integer.valueOf(textFromElement);
    }

//Citeste textul de pe elementul "totalNumberOfProducts". Imparte dupe separator " of ". Citeste valoarea de pe index [1] si salveaz-o ca int.
    public void readTotalNumberOfProducts(){
        String textFromElement = totalNumberOfProducts.getText();
        String[] splitedText = textFromElement.split(" of ");
        String totalProducts = splitedText[1];
        numberOfProducts = Integer.valueOf(totalProducts);
    }

//Calculeaza cate pagini returneaza in total cautarea si salveaza valoarea ca int. Daca pe ultima pagina sunt mai putine produse salveaza acel numar.
    public void totalNumberOfPages(){
        if(numberOfProducts % numberOfProductsDisplayedOnPage == 0){
            totalNumberOfPages = numberOfProducts / numberOfProductsDisplayedOnPage;
        }
        else{
            totalNumberOfPages = numberOfProducts / numberOfProductsDisplayedOnPage + 1;
            productsOnLastPage = numberOfProducts % numberOfProductsDisplayedOnPage;
        }
    }

    //Genereaza un numar random in intervalul inchis [1-numarul de pagini returnate de search].
    public void randomPageNumber() {
        int min = 1;
        int max = totalNumberOfPages;
        randomPageNumber = ThreadLocalRandom.current().nextInt(min, max + 1);
        System.out.println("Numarul paginii generat random: " + randomPageNumber);

    }

    //Navigheaza la randomPage by URL
    public void navigateToRandomPage() {
        String urlRandom = "https://fasttrackit.org/selenium-test/catalogsearch/result/index/?limit=12&p=" + randomPageNumber + "&q=a";
        getDriver().navigate().to(urlRandom);

    }

    //Genereaza un numar random in intervalul [0, numarul de produse afisate/pagina), indexul elementului produs.
    public void randomProduct(){
        int min = 0;
        int max;
        if(randomPageNumber == totalNumberOfPages && productsOnLastPage != 0) {
            max = productsOnLastPage;
        }else {
            max = numberOfProductsDisplayedOnPage;
        }
        randomIndexOfProduct = ThreadLocalRandom.current().nextInt(min, max);
        System.out.println("Indexul produsului generat random: " + randomIndexOfProduct);
    }
//Navigheaza la pagina produsului.
    public void moveToProductAndClick(){
        WebElementFacade product = productList.get(randomIndexOfProduct);
        product.getCoordinates().inViewPort().getX();
        selectedProductName = product.findBy(".product-info .product-name").getText();
        System.out.println("Numele produsului selectat random: " + selectedProductName);
        product.findBy(".product-info .product-name a").click();
    }

    public boolean searchResult(){
        return pageTitle.containsText("SEARCH RESULTS FOR");
    }


}
