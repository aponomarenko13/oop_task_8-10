
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final SellerService sellerService;

    @Override
    public void run(String[] args) {
        SellersEntity newSeller = sellerService.addNewSeller("Продукты", "Переведен из отдела хоз.товаров");
        System.out.println("Добавлен новый продавец с ID: " + newSeller.getSellersId());

        try {
            UUID existingSellerId = UUID.fromString("123e4567-e89b-12d3-a456-426614174000");
            sellerService.updateSellers(existingSellerId, "Одежда", "Новичок");
            System.out.println("Обновили продавца с ID: " + existingSellerId);

            sellerService.delSellerById(existingSellerId);
            System.out.println("Удалили продавца с ID: " + existingSellerId);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}