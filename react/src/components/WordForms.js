import React, {Component} from 'react';

class WordForms extends Component {
    render() {
        let wordForms = ['čučoriedka',  'čučoriedky', 'čučoriedke', 'čučoriedku', 'čučoriedke', 'čučoriedkou'];

        return (
            <div>
                <h2 className="f5 normal ma0 pv1">Všechna tvary slova:</h2>
                <ol className="mv0">
                    {wordForms.map((item, index) => (
                        <li className="" key={index}><strong>{item}</strong></li>
                    ))}
                </ol>
            </div>
        )
    }
}

export default WordForms;