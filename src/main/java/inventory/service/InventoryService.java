package inventory.service;

import inventory.entity.Inventory;
import inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository repository;

    public List<Inventory> get() {
        return this.repository.findAll();
    }

    public Inventory add(Inventory inventory) {
        return this.repository.save(inventory);
    }

    public Inventory update(Inventory inventory) {
        Optional<Inventory> inventoryOptional = this.repository.findById(inventory.getId());
        if (inventoryOptional.isEmpty()) {
            throw new RuntimeException();
        }
        Inventory inventoryDb = inventoryOptional.get();
        inventoryDb.setName(inventory.getName());
        inventoryDb.setQuantity(inventory.getQuantity());
        return this.repository.save(inventoryDb);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}