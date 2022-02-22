package ru.bnn.ArangoCatProject.Controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.bnn.ArangoCatProject.DataAccessObject.DataAccessObject;
import ru.bnn.ArangoCatProject.Model.HaveOwner;

import javax.validation.Valid;

@RestController
public class CommonController {
    private final DataAccessObject dao;

    public CommonController(DataAccessObject dao) {
        this.dao = dao;
    }

    @PostMapping("/cats/makehome")
    public HaveOwner create(@RequestBody @Valid JSONObject cat) {
        JSONObject fromData = null;
        try {
            fromData = cat.getJSONObject("data");
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        }

        HaveOwner edge = new HaveOwner();

        try {
            if (fromData != null) {
                dao.findCat(fromData.getString("catKey")).ifPresent(edge::set_from);
                dao.findOwner(fromData.getString("ownerKey")).ifPresent(edge::set_to);
            }
        } catch (JSONException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return dao.save(edge);
    }
}