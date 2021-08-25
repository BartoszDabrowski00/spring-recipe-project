package dabrowski.bartosz.springrecipe.services;

import dabrowski.bartosz.springrecipe.domain.Recipe;
import dabrowski.bartosz.springrecipe.repositories.RecipeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.io.IOException;

@Service
@AllArgsConstructor
@Slf4j
public class ImageServiceImpl implements ImageService {
    private final RecipeRepository recipeRepository;


    @Override
    @Transactional
    public void saveImageFile(Long id, MultipartFile file) {
        try{
            Recipe recipe = recipeRepository.findById(id).get();
            Byte[] byteObjects = new Byte[file.getBytes().length];
            int i=0;
            for(byte b : file.getBytes()){
                byteObjects[i++] = b;
            }
            recipe.setImage(byteObjects);
            recipeRepository.save(recipe);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
