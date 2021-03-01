package nl.han.ica.oose.dea.services;

import nl.han.ica.oose.dea.services.dto.ItemDTO;
import nl.han.ica.oose.dea.services.exceptions.IdAlreadyInUseException;
import nl.han.ica.oose.dea.services.exceptions.ItemNotAvailableException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface ItemService {

    /**
     * Return the full {@link List} of {@link ItemDTO} instances.
     *
     * @return The full {@link List} of {@link ItemDTO} instances.
     */
    public List<ItemDTO> getAll();

    /**
     * Add an item to the {@link List} of items.
     * <p>
     * Note that the newly added item should have an unique Id.
     *
     * @param itemDTO The {@link ItemDTO} to be added
     * @throws IdAlreadyInUseException Thrown if the Id is not unique
     */
    public void addItem(ItemDTO itemDTO);

    /**
     * Return a specific {@link ItemDTO} with the given Id.
     *
     * @param id The Id of the {@link ItemDTO} to be returned
     * @throws ItemNotAvailableException Thrown if there is no {@link ItemDTO} for the given Id
     */
    public ItemDTO getItem(int i);

    /**
     * Delete a specific {@link ItemDTO} with the given Id.
     *
     * @throws ItemNotAvailableException Thrown if there is no {@link ItemDTO} for the given Id
     */
    public void deleteItem(int id);

}
