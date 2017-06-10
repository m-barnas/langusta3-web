import React, {Component} from 'react';
import ReactTooltip from 'react-tooltip';
import Pattern from './Pattern';

class WordAnalysis extends Component {
  constructor(props) {
    super(props);

    this.state = {
      selectedPattern: null
    }
    
    this.handlePatternClick = this.handlePatternClick.bind(this);
  }
  handlePatternClick(selectedPattern) {
    let currentlyselectedPattern = this.state.selectedPattern;

    if (currentlyselectedPattern !== null) {
      currentlyselectedPattern.deselect();
    }

    this.setState({
      selectedPattern: selectedPattern
    });
  }

  render() {
    let patterns = ['atašé', 'admirál', 'lord', 'lady', 'tetanus', 'chlápek', 'cyklus'];
    patterns = [...patterns];

    return (
      <div>
        <table className="w-100 mw5 collapse tl mt4">
          <tbody>
            {/*<tr className="">
              <th className=" v-top pv1 normal">Pád:</th>
              <td className="w-100 pl3 v-top pv1 b">nominatív</td>
            </tr>*/}
            {/*<tr className="">
              <th className=" v-top pv1 normal">Rod:</th>
              <td className="w-100 pl3 v-top pv1 b">mužský</td>
            </tr>*/}
            <tr className="">
              <th className=" v-top pv1 normal">Infinitiv:</th>
              <td className="w-100 pl3 v-top pv1 b">huh</td>
            </tr>
            <tr className="">
              <th className=" v-top pv1 normal">Číslo:</th>
              <td className="w-100 pl3 v-top pv1 b">singulár</td>
            </tr>
            <tr className="">
              <th className=" v-top pv1 normal">Vzory:</th>
              <td className="w-100 pl2 pv0 v-top b">
                <ul className="list pl0 mv0 overflow-y-auto">
                  {patterns.map((item, index) => (
                    <li key={index}>
                      <Pattern 
                        className="Pattern ph2 pv1"
                        onClick={(selectedPattern) => {
                          this.handlePatternClick(selectedPattern);
                        }}
                      >{item}</Pattern>
                    </li>
                  ))}
                </ul>
                <ReactTooltip class="Tooltip" effect="solid"/>
              </td>
            </tr>
          </tbody>
        </table>
        {/*<div className="cf">
          <dl className="fl w-50 lh-title mt0 mb3">
            <dt className="f6 fw4 ml0">Pád</dt>
            <dd className="f3 fw7 ml0">nominatív</dd>
          </dl>
          <dl className="fl w-50 lh-title mt0 mb3">
            <dt className="f6 fw4 ml0">Rod</dt>
            <dd className="f3 fw7 ml0">mužský</dd>
          </dl>
          <dl className="fl w-50 lh-title mt0 mb3">
            <dt className="f6 fw4 ml0">Číslo</dt>
            <dd className="f3 fw7 ml0">singulár</dd>
          </dl>
          <dl className="fl w-50 lh-title mt0 mb3">
            <dt className="f6 fw4 ml0">Infinitiv</dt>
            <dd className="f3 fw7 ml0">huh</dd>
          </dl>
          <dl className="lh-title mt0 mb3">
            <dt className="f6 fw4 ml0">Vzory</dt>
            <dd className="f3 fw7 ml0">
              <ul className="list pl0 mv0 overflow-y-auto">
                  {patterns.map((item, index) => (
                    <li key={index}><a className="dib link underline-hover black" href="#" data-tip="Just the tip">{item}</a></li>
                  ))}
                </ul>
                <ReactTooltip class="Tooltip" effect="solid"/>
            </dd>
          </dl>
        </div>*/}
      </div>
    );
  }
}

export default WordAnalysis;