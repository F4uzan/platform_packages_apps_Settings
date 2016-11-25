package com.android.settings.simpleaosp;

import android.os.Bundle;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.Preference.OnPreferenceChangeListener;
import android.support.v7.preference.PreferenceScreen;
import android.support.v14.preference.SwitchPreference;
import android.provider.Settings;

import com.android.internal.logging.MetricsProto.MetricsEvent;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

public class NavigationBarSettings extends SettingsPreferenceFragment implements
        OnPreferenceChangeListener {

		// private variables here
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.navigation_bar_settings);

        // Enable or disable mStatusBarImeSwitcher based on boolean: config_show_cmIMESwitcher
        boolean showCmImeSwitcher = getResources().getBoolean(
                com.android.internal.R.bool.config_show_cmIMESwitcher);
        if (!showCmImeSwitcher) {
            getPreferenceScreen().removePreference(
                    findPreference(Settings.System.STATUS_BAR_IME_SWITCHER));
        }
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object objValue) {

		// preference changes here
        return false;
    }

    @Override
    protected int getMetricsCategory() {
        return MetricsEvent.SAOSP_TWEAKS;
    }
}
