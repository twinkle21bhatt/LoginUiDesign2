// Generated by view binder compiler. Do not edit!
package com.example.loginuidesign.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.loginuidesign.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView btnLogin;

  @NonNull
  public final EditText etLoginEmail;

  @NonNull
  public final EditText etLoginPassword;

  @NonNull
  public final ImageView icon;

  @NonNull
  public final ImageView usernameIcon;

  private ActivityLoginBinding(@NonNull ConstraintLayout rootView, @NonNull TextView btnLogin,
      @NonNull EditText etLoginEmail, @NonNull EditText etLoginPassword, @NonNull ImageView icon,
      @NonNull ImageView usernameIcon) {
    this.rootView = rootView;
    this.btnLogin = btnLogin;
    this.etLoginEmail = etLoginEmail;
    this.etLoginPassword = etLoginPassword;
    this.icon = icon;
    this.usernameIcon = usernameIcon;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_login;
      TextView btnLogin = ViewBindings.findChildViewById(rootView, id);
      if (btnLogin == null) {
        break missingId;
      }

      id = R.id.et_login_email;
      EditText etLoginEmail = ViewBindings.findChildViewById(rootView, id);
      if (etLoginEmail == null) {
        break missingId;
      }

      id = R.id.et_login_password;
      EditText etLoginPassword = ViewBindings.findChildViewById(rootView, id);
      if (etLoginPassword == null) {
        break missingId;
      }

      id = R.id.icon;
      ImageView icon = ViewBindings.findChildViewById(rootView, id);
      if (icon == null) {
        break missingId;
      }

      id = R.id.username_icon;
      ImageView usernameIcon = ViewBindings.findChildViewById(rootView, id);
      if (usernameIcon == null) {
        break missingId;
      }

      return new ActivityLoginBinding((ConstraintLayout) rootView, btnLogin, etLoginEmail,
          etLoginPassword, icon, usernameIcon);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}