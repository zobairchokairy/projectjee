package ma.emsi.projectj2ee;

import ma.emsi.projectj2ee.entities.Product;
import ma.emsi.projectj2ee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProjectJ2EeApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {

        SpringApplication.run(ProjectJ2EeApplication.class, args);
    }

    @Override
    public void run (String... args) throws Exception{
        productRepository.save(new Product(null,"Computer",4500,15));
        productRepository.save(new Product(null,"Printer",1200,3));
        productRepository.save(new Product(null,"Smart Phone",8600 ,8));
        List<Product> products = productRepository.findAll();
        products.forEach(p -> {
            System.out.println(p.toString());
        });
        Product product = productRepository.findById(Long.valueOf(1)).get();
        System.out.println("***************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("****************");
        List<Product> productList = productRepository.findByNameContains("C");
        productList.forEach(p->
                System.out.println(p));
        System.out.println("--------------------");
        List<Product> productList2 = productRepository.search("%C%");
        productList2.forEach(p->
                System.out.println(p));
        System.out.println("--------------------");
        List<Product> productList3 = productRepository.searchByPrice(3000);
        productList3.forEach(p->
                System.out.println(p));

    }



}
