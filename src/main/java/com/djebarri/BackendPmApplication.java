package com.djebarri;

import com.djebarri.dao.ProduitRepository;
import com.djebarri.enteties.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class BackendPmApplication implements CommandLineRunner {
    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private RepositoryRestConfiguration restConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(BackendPmApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Produit.class);
        produitRepository.save(new Produit(null,"Ordinateur1",4440,5));
        produitRepository.save(new Produit(null,"Ordinateur2",550,5));
        produitRepository.save(new Produit(null,"Ordinateur3",440,15));

        produitRepository.findAll().forEach(p->{
            System.out.println(p.toString());
        });
    }
}
