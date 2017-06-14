    import React, { Component } from 'react';

export default class AboutContainer extends Component {
  render() {
    return (
      <main className="About">
        <div className="Container pv5">
          <div className="measure center">
            <h1 className="tc mt0 lh-title">Webová aplikace pro přístup do morfologické databáze</h1>
            <p>Vytvorili sme free/slobodné dáta pre ohýbanie slov v češtine aj so systémom vzorov.</p>
            <p>Aktuálne máme označkované desiatky tisíc slov (XML+CSV), toto je nástroj umožňujúci prístup k týmto dátam.</p>
          </div>
        </div>
      </main>
    )
  }
}
