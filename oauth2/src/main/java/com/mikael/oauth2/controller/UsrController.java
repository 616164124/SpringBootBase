/*
 * projectName: SpringBootBase
 * fileName: UsrController.java
 * packageName: com.mikael.oauth2.controller
 * date: 2020-10-29
 * copyright(c) 2017-2020 xxx公司
 */
package com.mikael.oauth2.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @version: V1.0
 * @author: mikael
 * @className: UsrController
 * @packageName: com.mikael.oauth2.controller
 * @description:
 * @data: 2020-10-29
 **/
@RestController
@RequestMapping("user")
public class UsrController {

    @RequestMapping("getCurrentUser")
    public Object getCurrentUser(Authentication authentication) {
        return authentication.getPrincipal();
    }
}
