import template from "./monCompte.html"


class controller {
    constructor(ClientService) {
        this.ClientService = ClientService;

    }

}

export const MonCompte = {
    bindings: {},
    template,
    controller,
}