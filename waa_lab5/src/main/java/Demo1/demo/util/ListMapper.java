package Demo1.demo.util;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListMapper<T,E> {

    @Autowired
    ModelMapper modelMapper;


    public List<?> mapList(List<T> list, E convertTo){
        List<Object> result = new ArrayList<>();
        for (T e : list) {
            Object map = modelMapper.map(e, convertTo.getClass());
            result.add(map);
        }
        return
                result.stream().collect(Collectors.toList());
    }

}
