package com.example.demo;

import com.example.demo.dao.entities.*;
import com.example.demo.dao.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;

@SpringBootApplication
public class DonationManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(DonationManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(ActionRepository actionRepository,
                                   DonRepository donRepository) {
        return args -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Action action1 = new Action();
            action1.setTitre("Aide Scolaire 2025");
            action1.setDate(dateFormat.parse("2025-01-10"));
            action1.setDescription("Fourniture scolaire pour enfants");
            action1.setMontant(50000);
            action1.setStatus(Status.OUVERTE);
            actionRepository.save(action1);

            Action action2 = new Action();
            action2.setTitre("Distribution Alimentaire");
            action2.setDate(dateFormat.parse("2025-02-15"));
            action2.setDescription("Paniers alimentaires");
            action2.setMontant(30000);
            action2.setStatus(Status.PREPARATION);
            actionRepository.save(action2);

            Don don1 = new Don();
            don1.setTitre("Don Cartables");
            don1.setMontant(5000);
            don1.setType(Type.BIEN);
            don1.setDate(dateFormat.parse("2025-01-12"));
            don1.setDescription("20 cartables neufs");
            don1.setAction(action1);
            donRepository.save(don1);

            System.out.println("\n=== Base initialisée ===");
            System.out.println("Actions : " + actionRepository.count());
            System.out.println("Dons : " + donRepository.count());
            System.out.println("========================\n");
        };
    }
}