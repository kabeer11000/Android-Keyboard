package com.nlptech.keybaordwidget;


import android.content.Context;

import com.nlptech.function.gifsending.search.GifSearchWidget;
import com.nlptech.function.keyboardclipboard.KeyboardClipboardWidget;
import com.nlptech.function.keyboardmenu.KeyboardMenuWidget;
import com.nlptech.function.keyboardselector.KeyboardSelectorWidget;
import com.nlptech.inputmethod.latin.settings.Settings;
import com.nlptech.inputmethod.latin.utils.ResourceUtils;
import com.nlptech.keyboardview.keyboard.KeyboardSwitcher;

public class KeyboardWidgetManager extends BaseKeyboardWidgetManager {
    public static final String TAG = KeyboardWidgetManager.class.getSimpleName();

    private static final KeyboardWidgetManager sInstance = new KeyboardWidgetManager();

    private KeyboardWidgetManager() {
    }

    public static KeyboardWidgetManager getInstance() {
        return sInstance;
    }

    public int getTotalKeyboardHeight(Context context) {
        boolean isFloatingKeyboard = KeyboardSwitcher.getInstance().isFloatingKeyboard();
        int keyboardHeight = ResourceUtils.getKeyboardHeight(context, isFloatingKeyboard);
        int functionStripViewHeight = ResourceUtils.getSuggestionStripViewHeight(context);
        return keyboardHeight + functionStripViewHeight;
    }

    public int getSuggestionStripViewHeight(Context context) {
        return ResourceUtils.getSuggestionStripViewHeight(context);
    }

    public void closeFunctionStripWidget() {
        close(KeyboardMenuWidget.class);
        close(KeyboardSelectorWidget.class);
        close(KeyboardClipboardWidget.class);
        close(GifSearchWidget.class);
        //TODO add others
    }
}
