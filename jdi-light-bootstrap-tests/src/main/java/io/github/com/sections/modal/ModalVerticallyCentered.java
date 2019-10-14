package io.github.com.sections.modal;

import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class ModalVerticallyCentered extends Modal {

    @UI("button:nth-of-type(1)")
    public Button modalCenterTrigger;

    @UI("button:nth-of-type(2)")
    public Button modalCenterScrollableTrigger;

    @UI("#exModalCenter")
    public Modal modalCenterBg;

    @UI("#exampleModalCenteredScrollable")
    public Modal modalCenterScrollableBg;

    @UI("#modal-vertical-content-1")
    public Modal modal1;

    @UI("#modal-vertical-content-2")
    public Modal modal2;

    @UI("//*[@id='modal-vertical-content-1']//button[contains(., 'Close')]")
    public Button dismissModal1Close;

    @UI("//*[@id='modal-vertical-content-1']//div//button//span")
    public Button dismissModal1Cross;

    @UI("//*[@id='modal-vertical-content-2']//button[contains(., 'Close')]")
    public Button dismissModal2Close;

    @UI("//*[@id='modal-vertical-content-2']//div//button//span")
    public Button dismissModal2Cross;

    @Title
    @UI("//*[@id='modal-vertical-content-1']//div//h5")
    public Text modal1Title;

    @UI("//*[@id='modal-vertical-content-1']//*[@class='modal-body']//p")
    public Modal modal1Content;

    @Title
    @UI("//*[@id='modal-vertical-content-2']//div//h5")
    public Text modal2Title;

    @UI("//*[@id='modal-vertical-content-2']//*[@class='modal-body']//p")
    public Modal modal2Content;

}
