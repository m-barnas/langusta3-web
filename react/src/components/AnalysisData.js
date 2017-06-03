import React, {Component} from 'react';

class AnalysisData extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <table className="collapse w-50 tl">
        <tbody>
          <tr>
            <th className="w-30 v-top pv1 normal ">Pád:</th>
            <td className="w-70 v-top pv1 b dark-gray">nominatív</td>
          </tr>
          <tr>
            <th className="w-30 v-top pv1 normal ">Rod:</th>
            <td className="w-70 v-top pv1 b dark-gray">mužský</td>
          </tr>
          <tr>
            <th className="w-30 v-top pv1 normal ">Číslo:</th>
            <td className="w-70 v-top pv1 b dark-gray">singulár</td>
          </tr>
          <tr>
            <th className="w-30 v-top pv1 normal ">Infinitiv:</th>
            <td className="w-70 v-top pv1 b dark-gray">huh</td>
          </tr>
          <tr>
            <th className="w-30 v-top pv1 normal ">Vzory:</th>
            <td className="w-70 v-top pv1 b dark-gray">
              <ul className="list pl0 mv0">
                <li><a className="link underline-hover black" href="#">dub</a></li>
                <li><a className="link underline-hover black" href="#">stroj</a></li>
                <li><a className="link underline-hover black" href="#">chlap</a></li>
              </ul>
            </td>
          </tr>
        </tbody>
      </table>
    );
  }
}

export default AnalysisData;