package imat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import org.jetbrains.annotations.Nullable;
import se.chalmers.cse.dat216.project.Product;

import javax.swing.text.html.ListView;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProductBrowse extends AnchorPane {
    @FXML FlowPane productFlowPane;
    private Map<Integer, ProductItem> productListItemMap = new HashMap<Integer, ProductItem>();

    public ProductBrowse(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fx/productbrowse.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private void updateRecipeList(@Nullable ProductFilter productFilter){
        var ids = Controller.getFilteredProductIds(productFilter);

        productFlowPane.getChildren().clear();
        for(Integer i : ids){
            ProductItem productListItem = Controller.getProdListItem(i);
            productFlowPane.getChildren().add(productListItem);
        }
    }
}
