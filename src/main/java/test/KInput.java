package test;

public class KInput {
    
    public static final String SEQUENCE = """
        FIELD $object_data_1 MUTATE OBJECT
            FIELD $integer INCREMENT 11.95
            FIELD $string MUTATE "str 2"
            FIELD $boolean MUTATE false
        CLOSE
        FIELD $list_data MUTATE LIST
            10 11 12 13
        CLOSE
        FIELD $complex_list_data AS LIST
            OBJECT
                FIELD $integer AS 311
                FIELD $string AS "str 3"
            CLOSE
        CLOSE
        FIELD $erase DELETE
        FIELD object_data_complex_1 MUTATE OBJECT
            FIELD $integer AS 4
        CLOSE
        FIELD $object_data_complex_2 AS OBJECT
            FIELD $sub_object_data_complex_2 AS OBJECT
                FIELD $integer AS 12
                FIELD $string AS "str 5"
                FIELD $boolean AS true
            CLOSE
        CLOSE
            """;

    public static final String BASE = """
            {
                "$object_data_1":{
                  "$integer": 1,
                  "$string": "empty 1",
                  "$boolean": true,
                  "$string_new": "str 1"
                },
                "$list_data": [0],
                "$erase": "this_field_out",
                "object_data_complex_1":{
                  "$integer": "3",
                  "sub_object_data_complex_1": {
                      "$string": "str 4"
                  }
                }
              }
                """;

}