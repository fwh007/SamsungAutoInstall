package com.dt.lib.samsungautoinstall;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.util.List;

public class AutoInstallService extends AccessibilityService {

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (event.getSource() != null) {
            List<AccessibilityNodeInfo> nodeInfoList = event.getSource().findAccessibilityNodeInfosByViewId("com.android.settings:id/button");
            if (!nodeInfoList.isEmpty()) {
                AccessibilityNodeInfo nodeInfo = nodeInfoList.get(0);
                if (nodeInfo.getClassName().equals("android.widget.Button") && nodeInfo.isEnabled()) {
                    nodeInfo.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                }
            }
        }
    }

    @Override
    public void onInterrupt() {
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
