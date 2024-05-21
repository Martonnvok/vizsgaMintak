
class MegjelenesView {
    #adat = [];
    #leiro = [];
    constructor(szuloElem, adat, leiro) {
        this.#adat = adat;
        this.#leiro = leiro;
        this.divElem = szuloElem;
        
        this.#megjelenitAdat();
        this.#gombok();

    }

    #megjelenitAdat() {
        let txt = `<div class='divContainer'>`;

        for (const key in this.#adat) {
            txt += `
                <div class="divStilus egySor">
                    <p>Azonosító: ${this.#adat[key].id}</p>
                    <p>Név: ${this.#adat[key].nev}</p>
                    <p>Születési év: ${this.#adat[key].szul}</p>
                </div>
            `;
        }

        txt += `</div>`;
        this.divElem.append(txt);
    }

    #gombok() {
        this.divElem.on("click", (event) => {
            const sorElem = $(event.currentTarget);
            const keszElem = sorElem.find(".kesz");
            const torolElem = sorElem.find(".torol");
            const megseElem = sorElem.find(".megse");

            if (keszElem.is(event.target)) {
                sorElem.css("background-color", "lightgreen");
                megseElem.css("display", "inline");
                keszElem.css("display", "none");
                this.#esemenyTrigger("kesz");
            } else if (megseElem.is(event.target)) {
                sorElem.css("background-color", "white");
                megseElem.css("display", "none");
                keszElem.css("display", "inline");
                this.#esemenyTrigger("megse");
            } else if (torolElem.is(event.target)) {
                sorElem.remove();
                this.#esemenyTrigger("torol");
            }
        });
    }

    #esemenyTrigger(esemenyNev) {
        const esemeny = new CustomEvent(esemenyNev);
        window.dispatchEvent(esemeny);
    }
}





export default MegjelenesView;