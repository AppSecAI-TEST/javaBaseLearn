package com.learn.serializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by xia_yu on 2017/4/20.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="user")
@XmlType(propOrder = {
        "userId",
        "userName",
        "password",
        "birthday",
        "money"
})
public class User implements Serializable {
    private static final long serialVersionUID=1L;
    private int userId;
    private String userName;
    private String password;
    private Date birthday;
    private double money;
}
