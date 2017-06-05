import React, {Component} from 'react';
import ReactTooltip from 'react-tooltip';

class WordAnalysis extends Component {
  // constructor(props) {
  //   super(props);
  // }

  render() {
    let patterns = ['dub', 'stroj', 'chlap'];
    patterns = [...patterns, ...patterns];

    return (
      <table className="w-100 collapse tl">
        <tbody>
          <tr className="">
            <th className="w-40 v-top pv1 normal">Pád:</th>
            <td className="w-60 v-top pv1 b">nominatív</td>
          </tr>
          <tr className="">
            <th className="w-40 v-top pv1 normal">Rod:</th>
            <td className="w-60 v-top pv1 b">mužský</td>
          </tr>
          <tr className="">
            <th className="w-40 v-top pv1 normal">Číslo:</th>
            <td className="w-60 v-top pv1 b">singulár</td>
          </tr>
          <tr className="">
            <th className="w-40 v-top pv1 normal">Infinitiv:</th>
            <td className="w-60 v-top pv1 b">huh</td>
          </tr>
          <tr className="">
            <th className="w-40 v-top pv1 normal">Vzory:</th>
            <td className="w-60 v-top pv1 b">
              <ul className="list pl0 mv0 overflow-y-auto">
                {patterns.map((item, index) => (
                  <li key={index}><a className="dib link underline-hover black" href="#" data-tip="Just the tip">{item}</a></li>
                ))}
              </ul>
              <ReactTooltip class="Tooltip" effect="solid"/>
            </td>
          </tr>
        </tbody>
      </table>
    );
  }
}

export default WordAnalysis;