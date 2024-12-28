
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SellerService {
    private final SellersRepository sellersRepository;

    @Transactional
    public SellersEntity updateSellers(UUID sellerId, String sellerSpecialization, String description) {
        Optional<SellersEntity> sellerOpt = sellersRepository.findById(sellerId);
        if (sellerOpt.isPresent()) {
            SellersEntity seller = sellerOpt.get();
            seller.setSpecialization(sellerSpecialization);
            seller.setDescription(description);
            return sellersRepository.save(seller);
        } else {
            throw new IllegalArgumentException("Seller with ID " + sellerId + " not found.");
        }
    }

    @Transactional
    public SellersEntity addNewSeller(String sellerSpecialization, String description) {
        SellersEntity seller = new SellersEntity();
        seller.setSellersId(UUID.randomUUID());
        seller.setSpecialization(sellerSpecialization);
        seller.setDescription(description);
        return sellersRepository.save(seller);
    }

    @Transactional
    public void delSellerById(UUID sellerId) {
        if (!sellersRepository.existsById(sellerId)) {
            throw new IllegalArgumentException("Seller with ID " + sellerId + " not found.");
        }
        sellersRepository.deleteById(sellerId);
    }
}