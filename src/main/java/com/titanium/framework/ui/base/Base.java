package com.titanium.framework.ui.base;

import com.titanium.framework.general.PropertyManager;
import com.titanium.framework.ui.controls.api.ControlFactory;

public class Base {
    public static Base currentPage;
    public <TPage extends  Base> TPage getInstance(Class<TPage> page){
        Object obj;
        if(Boolean.parseBoolean(PropertyManager.getInstance().getProperty("Remote_Driver"))){
            obj = ControlFactory.initElements(RemoteDriverFactory.getInstance().getDriver(), page);
        }else{
            obj = ControlFactory.initElements(DriverFactory.getInstance().getDriver(), page);
        }
        return page.cast(obj);
    }

    public <TPage extends Base> TPage as(Class<TPage> pageInstance){
        try{
            return (TPage)this;
        }catch (Exception e){
            e.getStackTrace();
        }

        return null;
    }

}
