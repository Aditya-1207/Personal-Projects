import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {

    //List to consume the input data
    public List<Product> products;

    public ProductCatalog(String inputfilePath) {
        products = new ArrayList<>();
        loadFile(inputfilePath);
    }

    public  List<Product> searchProduct(String productName) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if(p.getName().contains(productName)){
                result.add(p);
            }
        }
        return  result;
    }

    public List<Product> globalSearch(String searchString) {

        List<Product> resultList = new ArrayList<>();
        for (Product p : products) {
            List<String> tempList = new ArrayList<>();
            tempList.add(p.getName());
            tempList.add(p.getId());
            tempList.add(p.getInventory_Status());
            tempList.add(String.valueOf(p.getMax_allowed_quantity()));
            tempList.add(String.valueOf(p.getMrp_Price()));
            tempList.add(String.valueOf(p.getDiscount()));
            if(tempList.contains(searchString)){
                resultList.add(p);
            }
        }

        printProductResult(resultList);
        return  resultList;
    }

    public void printProductResult(List<Product> productList){
        for(Product p : productList){
            System.out.println(p.getId()+","+p.getName()+","+p.getInventory_Status()+","+p.getDiscount()+","+p.getMrp_Price()+","+p.getMax_allowed_quantity());
        }
    }

    /**
     * Method will be used to load the input csv file
     *
     * @param inputfilePath
     */
    public void loadFile(String inputfilePath) {


        try {
            File file = new File(inputfilePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String newLine = bufferedReader.readLine();

            while (newLine != null) {

                String[] productData = newLine.split(",");
                String id = productData[0];
                String name = productData[1];
                String inventory_Status = productData[2];
                Double mrp_Price = Double.parseDouble(productData[3]);
                Double discount = Double.parseDouble(productData[4]);
                int max_allowed_quantity = Integer.parseInt(productData[5]);

                //Create a product object
                Product product = new Product(id, name, inventory_Status, mrp_Price, discount, max_allowed_quantity);
                products.add(product);

                newLine = bufferedReader.readLine();
            }

        } catch (IOException e) {
            System.err.println("Please check the input file " + e.getMessage());
        }


    }


}