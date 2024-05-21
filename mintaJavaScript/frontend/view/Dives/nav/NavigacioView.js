class NavigacioView {
    #adat = {};
    constructor(szuloElem, adat) {
        this.navElem = szuloElem;
        this.#adat = adat;
        
        this.nav();

    }

    nav() {
        let txt = `<div class = "navigacio egySorNav">`;
        for (const key in this.#adat) {
            txt += `<a href="${this.#adat[key].href}">${this.#adat[key].nev}</a>`;

        }
        txt += `</div>`;
        this.navElem.append(txt);
    }

}
export default NavigacioView;