package ru.profiteam.admin.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.server.auth.AccessAnnotationChecker;
import java.util.Optional;
import ru.profiteam.admin.components.appnav.AppNav;
import ru.profiteam.admin.components.appnav.AppNavItem;
import ru.profiteam.admin.data.entity.User;
import ru.profiteam.admin.security.AuthenticatedUser;
import ru.profiteam.admin.views.заказы.ЗаказыView;
import ru.profiteam.admin.views.клиенты.КлиентыView;
import ru.profiteam.admin.views.продукты.ПродуктыView;
import ru.profiteam.admin.views.сотрудники.СотрудникиView;
import ru.profiteam.admin.views.чатстехподдержкой.ЧатстехподдержкойView;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H1 viewTitle;

    private AuthenticatedUser authenticatedUser;
    private AccessAnnotationChecker accessChecker;

    public MainLayout(AuthenticatedUser authenticatedUser, AccessAnnotationChecker accessChecker) {
        this.authenticatedUser = authenticatedUser;
        this.accessChecker = accessChecker;

        setPrimarySection(Section.DRAWER);
        addToNavbar(true, createHeaderContent());
        addToDrawer(createDrawerContent());
    }

    private Component createHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.addClassNames("view-toggle");
        toggle.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        toggle.getElement().setAttribute("aria-label", "Menu toggle");

        viewTitle = new H1();
        viewTitle.addClassNames("view-title");

        Header header = new Header(toggle, viewTitle);
        header.addClassNames("view-header");
        return header;
    }

    private Component createDrawerContent() {
        H2 appName = new H2("WaterShop");
        appName.addClassNames("app-name");

        com.vaadin.flow.component.html.Section section = new com.vaadin.flow.component.html.Section(appName,
                createNavigation(), createFooter());
        section.addClassNames("drawer-section");
        return section;
    }

    private AppNav createNavigation() {
        AppNav nav = new AppNav();
        nav.addClassNames("app-nav");

        if (accessChecker.hasAccess(ПродуктыView.class)) {
            nav.addItem(new AppNavItem("Продукты", ПродуктыView.class, "la la-columns"));

        }
        if (accessChecker.hasAccess(КлиентыView.class)) {
            nav.addItem(new AppNavItem("Клиенты", КлиентыView.class, "la la-columns"));

        }
        if (accessChecker.hasAccess(ЗаказыView.class)) {
            nav.addItem(new AppNavItem("Заказы", ЗаказыView.class, "la la-columns"));

        }
        if (accessChecker.hasAccess(СотрудникиView.class)) {
            nav.addItem(new AppNavItem("Сотрудники", СотрудникиView.class, "la la-columns"));

        }
        if (accessChecker.hasAccess(ЧатстехподдержкойView.class)) {
            nav.addItem(new AppNavItem("Чат с техподдержкой ", ЧатстехподдержкойView.class, "la la-comments"));

        }

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();
        layout.addClassNames("app-nav-footer");

        Optional<User> maybeUser = authenticatedUser.get();
        if (maybeUser.isPresent()) {
            User user = maybeUser.get();

            Avatar avatar = new Avatar(user.getName(), user.getProfilePictureUrl());
            avatar.addClassNames("me-xs");

            ContextMenu userMenu = new ContextMenu(avatar);
            userMenu.setOpenOnClick(true);
            userMenu.addItem("Logout", e -> {
                authenticatedUser.logout();
            });

            Span name = new Span(user.getName());
            name.addClassNames("font-medium", "text-s", "text-secondary");

            layout.add(avatar, name);
        } else {
            Anchor loginLink = new Anchor("login", "Sign in");
            layout.add(loginLink);
        }

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
