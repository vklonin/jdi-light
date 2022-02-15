package com.epam.jdi.light.mobile.elements.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.LocksDevice;
import io.appium.java_client.HasDeviceTime;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AuthenticatesByFinger;
import io.appium.java_client.android.HasAndroidClipboard;
import io.appium.java_client.android.HasSupportedPerformanceDataType;
import io.appium.java_client.battery.BatteryInfo;
import io.appium.java_client.clipboard.HasClipboard;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.PerformsTouchID;
import io.appium.java_client.ios.ShakesDevice;
import io.appium.java_client.remote.SupportsLocation;
import io.appium.java_client.remote.SupportsRotation;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.Location;

import java.time.Duration;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.mobile.MobileUtils.executeDriverMethod;

public class MobileDevice {
    public static void rotate(DeviceRotation rotation) {
        executeDriverMethod(SupportsRotation.class, (SupportsRotation driver) -> driver.rotate(rotation));
    }

    public static DeviceRotation getRotation() {
        return executeDriverMethod(SupportsRotation.class,
                (Function<SupportsRotation, DeviceRotation>) SupportsRotation::rotation);
    }

    public static void rotate(ScreenOrientation orientation) {
        executeDriverMethod(SupportsRotation.class, (SupportsRotation driver) -> driver.rotate(orientation));
    }

    public static ScreenOrientation getOrientation() {
        return executeDriverMethod(SupportsRotation.class,
                (Function<SupportsRotation, ScreenOrientation>) SupportsRotation::getOrientation);
    }

    public static void lockDevice() {
        executeDriverMethod(LocksDevice.class, (Consumer<LocksDevice>) LocksDevice::lockDevice);
    }

    public static void lockDevice(Duration duration) {
        executeDriverMethod(LocksDevice.class, (LocksDevice driver) -> driver.lockDevice(duration));
    }

    public static void unlockDevice() {
        executeDriverMethod(LocksDevice.class, LocksDevice::unlockDevice);
    }

    public static boolean isLocked() {
        return executeDriverMethod(LocksDevice.class, LocksDevice::isDeviceLocked);
    }

    public static BatteryInfo getBatteryInfo() {
        WebDriver driver = getDriver();
        if (driver instanceof IOSDriver) {
            return ((IOSDriver) driver).getBatteryInfo();
        } else if (driver instanceof AndroidDriver) {
            return ((AndroidDriver) driver).getBatteryInfo();
        } else {
            throw runtimeException("This method is not supported by the driver. The driver needs to be the instance of either Ios or Android driver");
        }
    }

    public static Location getLocation() {
        return executeDriverMethod(SupportsLocation.class, (Function<SupportsLocation, Location>) SupportsLocation::location);
    }

    public static void setLocation(Location location) {
        executeDriverMethod(SupportsLocation.class, (SupportsLocation driver) -> driver.setLocation(location));
    }

    public static String getDeviceTime() {
        return executeDriverMethod(HasDeviceTime.class, (Function<HasDeviceTime, String>) HasDeviceTime::getDeviceTime);
    }

    public static String getDeviceTime(String format) {
        return executeDriverMethod(HasDeviceTime.class, (HasDeviceTime driver) -> driver.getDeviceTime(format));
    }

    // the next methods are for IOS only
    public static void shake() {
        executeDriverMethod(ShakesDevice.class, ShakesDevice::shake);
    }

    public static void performTouchId(boolean match) {
        executeDriverMethod(PerformsTouchID.class, (PerformsTouchID driver) -> driver.performTouchID(match));
    }

    public static void toggleTouchIDEnrollment(boolean enabled) {
        executeDriverMethod(PerformsTouchID.class, (PerformsTouchID driver) -> driver.toggleTouchIDEnrollment(enabled));
    }

    // the next methods are for Android only
    public static void fingerPrint(int fingerPrintId) {
        executeDriverMethod(AuthenticatesByFinger.class, (AuthenticatesByFinger driver) -> driver.fingerPrint(fingerPrintId));
    }

    // this method is for Android only
    public static void setClipBoardText(String text) {
        executeDriverMethod(HasAndroidClipboard.class,
                (HasAndroidClipboard driver) -> (HasAndroidClipboard) driver).setClipboardText(text);
    }
    // this method is for Android only
    public static String getClipBoardText() {
        return executeDriverMethod(HasAndroidClipboard.class,
                (HasAndroidClipboard driver) -> (HasAndroidClipboard) driver).getClipboardText();
    }

    public static List<String> getPerformanceDataTypes() {
        return executeDriverMethod(HasSupportedPerformanceDataType.class, HasSupportedPerformanceDataType::getSupportedPerformanceDataTypes);
    }

    public static List<List<Object>> getPerformanceData(String packageName, String dataType, int dataReadTimeout) {
        return executeDriverMethod(HasSupportedPerformanceDataType.class, (HasSupportedPerformanceDataType driver) -> driver.getPerformanceData(packageName, dataType, dataReadTimeout));
    }

    public static void sendSMS(String phoneNumber, String smsText) {
        executeDriverMethod(AndroidDriver.class,
                (AndroidDriver driver) -> driver.sendSMS(phoneNumber, smsText));
    }
}
