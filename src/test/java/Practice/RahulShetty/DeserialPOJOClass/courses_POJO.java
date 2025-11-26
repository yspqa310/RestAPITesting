package Practice.RahulShetty.DeserialPOJOClass;

import java.util.List;

public class courses_POJO {
    private List<webAutomation_POJO> webAutomation;
    private List<api_POJO> api;
    private List<mobile_POJO> mobile;

    public List<webAutomation_POJO> getWebAutomation() {
        return webAutomation;
    }

    public void setWebAutomation(List<webAutomation_POJO> webAutomation) {
        this.webAutomation = webAutomation;
    }

    public List<api_POJO> getApi() {
        return api;
    }

    public void setApi(List<api_POJO> api) {
        this.api = api;
    }

    public List<mobile_POJO> getMobile() {
        return mobile;
    }

    public void setMobile(List<mobile_POJO> mobile) {
        this.mobile = mobile;
    }
}
