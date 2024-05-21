import TextUrlapElem from "./TextUrlapElem.js";
import NumberUrlapElem from "./NumberUrlapElem.js";

class UrlapView {
  #leiro = {};
  #urlapElemLista = [];
  #osszesElemValidE = true;
  #urlapAdat = {};
  #beteszie
  #adatSor

  constructor(szuloElem, leiro, beteszie) {
    this.#beteszie = beteszie;
    this.szuloElem = szuloElem;
    this.#leiro = leiro;
    this.szuloElem.append("<form>");
    this.formElem = this.szuloElem.children("form");
    this.urlapOsszerak();
    this.submitElem = $(".felvisz");
    this.submitElem.on("click", (event) => {
      event.preventDefault();
      this.#osszesElemValidE = true;
      this.#urlapElemLista.forEach(elem=>{
        this.#osszesElemValidE = this.#osszesElemValidE && elem.valid;
      })
      if(this.#osszesElemValidE){
        this.#urlapElemLista.forEach((elem)=>{
            this.#urlapAdat[elem.key] = elem.value;
        })
        console.log("Valid az űrlap")
      }else{
        console.log("Nem valid az űrlap");
      }
      if(this.#beteszie == true){
        this.#esemenyTrigger("betesz");
      }
      if(this.#beteszie == false){
        this.#esemenyTrigger("szerkeszt");
      }
    });
  
  }

  get urlapAdat(){
    return this.#urlapAdat;
  }

  setadatid(adatSor){
    this.#adatSor = adatSor
  }


  urlapOsszerak() {
    for (const key in this.#leiro) {
      switch (this.#leiro[key].tipus) {
        case "text":
          this.#urlapElemLista.push(new TextUrlapElem(key, this.#leiro[key], this.formElem, this.#beteszie))
          break;
        case "number":
            this.#urlapElemLista.push(new NumberUrlapElem(key, this.#leiro[key], this.formElem, this.#beteszie));
          break;
        default:
      }
    }
    let txt = "<input type='submit' class='felvisz' value='Felvissz'>";
    this.formElem.append(txt);
  }

  #esemenyTrigger(esemenyNev){
    const esemenyem = new CustomEvent(esemenyNev, { detail: this.#urlapAdat });
    window.dispatchEvent(esemenyem);
  }


}
export default UrlapView;