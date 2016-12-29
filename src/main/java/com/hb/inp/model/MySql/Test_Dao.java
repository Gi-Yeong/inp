package com.hb.inp.model.MySql;

import java.util.List;

public interface Test_Dao {

    List<Test_Vo> selectAll();

    void mysql(String db_info);

}
