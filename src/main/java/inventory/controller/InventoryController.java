package inventory.controller;

import inventory.entity.Inventory;
import inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {
    @Autowired
    InventoryService service;

    @CrossOrigin
    @GetMapping(value = "/api/inventory")
    public List<Inventory> get() {
        return this.service.get();
    }

    @CrossOrigin
    @PostMapping(value = "/api/inventory")
    public Inventory add(@RequestBody Inventory inventory) {
        return this.service.add(inventory);
    }

    @CrossOrigin
    @PutMapping(value = "/api/inventory", consumes = "application/json")
    public Inventory update(@RequestBody Inventory inventory) {
        return this.service.update(inventory);
    }

    @CrossOrigin
    @DeleteMapping(value = "/api/food/{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}
