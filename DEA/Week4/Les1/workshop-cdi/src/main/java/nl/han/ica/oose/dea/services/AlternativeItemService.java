package nl.han.ica.oose.dea.services;

import nl.han.ica.oose.dea.services.dto.ItemDTO;

import javax.enterprise.inject.Alternative;
import java.util.List;

@Alternative
public class AlternativeItemService implements ItemService{
    @Override
    public List<ItemDTO> getAll() {
        return null;
    }

    @Override
    public void addItem(ItemDTO itemDTO) {

    }

    @Override
    public ItemDTO getItem(int i) {
        return null;
    }

    @Override
    public void deleteItem(int id) {

    }
}
