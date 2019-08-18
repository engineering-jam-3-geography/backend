package edumaps.app.service;

import edumaps.app.domain.Answer;
import edumaps.app.domain.InteractionType;
import edumaps.app.domain.Task;
import edumaps.app.domain.Visual;
import edumaps.util.GMapsFormat;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.awt.geom.Path2D;
import java.util.List;


@Service
@Qualifier("MAP_TEXT")
public class MapTextAnswerEvaluator implements AnswerEvaluator {

    @Override
    public boolean evaluate(Task task, Answer answer) {

        for (Answer taskAnswer : task.getDefinedAnswers()) {
            if (taskAnswer.getType() == InteractionType.MAP_TEXT) {
                if (taskAnswer.getValue().get("text").equals(answer.getValue().get("text"))
                        &&
                        withinTerritory(answer.getValue().get("location"),
                                getVisualLocation(task, taskAnswer.getValue().get("visualId")))) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean withinTerritory(String location, List<GMapsFormat> visualLocation) {
        if (StringUtils.isBlank(location) || CollectionUtils.isEmpty(visualLocation)) {
            return false;
        }

        Path2D path = new Path2D.Double();

        List<GMapsFormat> listToPath = visualLocation.subList(1, visualLocation.size());
        path.moveTo(visualLocation.get(0).getLat(), visualLocation.get(0).getLng());


        for (GMapsFormat gMapsFormat : listToPath) {
            path.lineTo(gMapsFormat.getLat(), gMapsFormat.getLng());
        }
        path.closePath();

        String[] coords = location.split(",");
        path.contains(Double.valueOf(coords[0]), Double.valueOf(coords[1]));

        return path.contains(Double.valueOf(coords[0]), Double.valueOf(coords[1]));
    }

    private List<GMapsFormat> getVisualLocation(Task task, String visualId) {
        for (Visual visual : task.getVisuals()) {
            if (visualId.equals(visual.getId())) {
                return visual.getLocation();
            }
        }
        return null;
    }
}
