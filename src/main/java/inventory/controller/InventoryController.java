package inventory.controller;

import inventory.entity.Inventory;
import inventory.model.Recipe;
import inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    InventoryService service;

    @CrossOrigin
    @GetMapping
    public List<Inventory> get() {
        return this.service.get();
    }

    @CrossOrigin
    @PostMapping
    public Inventory add(@RequestBody Inventory inventory) {
        return this.service.add(inventory);
    }

    @CrossOrigin
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Inventory update(@RequestBody Inventory inventory) {
        return this.service.update(inventory);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }

    @CrossOrigin
    @PostMapping(value = "/isAvailable")
    public boolean isAvailable(@RequestBody Recipe recipe) {
        return this.service.isAvailable(recipe);
    }

}
