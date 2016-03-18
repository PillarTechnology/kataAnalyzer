package controllers;

import models.Kata;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.Result;
import play.mvc.*;
import views.html.success;

import javax.inject.Inject;

public class KataController extends Controller {

    public FormFactory formFactory;

    @Inject
    public KataController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }
    public Result create() {
        Form<Kata> form = formFactory.form(Kata.class).bindFromRequest();
        return ok(success.render(form.get()));
    }

}
