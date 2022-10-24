package mikael.web.action;

import mikael.web.ServiceResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping
@RestController
public class WebAction {

    @RequestMapping(value = "/say01",method = RequestMethod.GET)
    public ServiceResult say01(HttpServletRequest request){
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setResultMsg("say01");
        String id = request.getSession().getId();

        return serviceResult;
    }

}
