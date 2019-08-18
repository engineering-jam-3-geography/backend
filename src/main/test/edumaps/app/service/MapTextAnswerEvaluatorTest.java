package edumaps.app.service;


import com.google.common.collect.Lists;
import edumaps.app.domain.Answer;
import edumaps.app.domain.InteractionType;
import edumaps.app.domain.Task;
import edumaps.app.domain.Visual;
import edumaps.util.GMapsFormat;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTextAnswerEvaluatorTest {

    @Test
    public void testEvaluationSuccess() {
        //given
        MapTextAnswerEvaluator mapTextAnswerEvaluator = new MapTextAnswerEvaluator();
        Task task = new Task();
        Visual visual = new Visual();
        visual.setId("vis1");
        List<GMapsFormat> coords = new ArrayList<>();
        coords.add(new GMapsFormat(1.0, 1.0));
        coords.add(new GMapsFormat(3.0, 1.0));
        coords.add(new GMapsFormat(3.0, 3.0));
        coords.add(new GMapsFormat(1.0, 3.0));
        visual.setLocation(coords);
        List<Visual> visuals = Lists.newArrayList(visual);
        task.setVisuals(visuals);
        Answer defined = new Answer();
        defined.setType(InteractionType.MAP_TEXT);
        Map<String, String> definedValue = new HashMap<>();
        definedValue.put("text", "Минас-Тирит");
        definedValue.put("visualId", "vis1");
        defined.setValue(definedValue);
        task.setDefinedAnswers(Lists.newArrayList(defined));
        Answer answer = new Answer();
        answer.setType(InteractionType.MAP_TEXT);
        Map<String, String> answeredValue = new HashMap<>();
        answeredValue.put("text", "Минас-Тирит");
        answeredValue.put("location", "2.0,2.0");
        answer.setValue(answeredValue);
        //when
        boolean result = mapTextAnswerEvaluator.evaluate(task, answer);
        //then
        Assert.assertTrue(result);
    }

}
