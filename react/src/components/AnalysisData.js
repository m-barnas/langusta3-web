import React, {Component} from 'react';

class AnalysisData extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <table className="collapse w-50 tl center">
        <tr>
          <th className="w-20 v-top pb2 normal ">Pád:</th>
          <td className="w-80 v-top pb2 b dark-gray">nominatív</td>
        </tr>
        <tr>
          <th className="w-20 v-top pb2 normal ">Rod:</th>
          <td className="w-80 v-top pb2 b dark-gray">mužský</td>
        </tr>
        <tr>
          <th className="w-20 v-top pb2 normal ">Číslo:</th>
          <td className="w-80 v-top pb2 b dark-gray">singulár</td>
        </tr>
        <tr>
          <th className="w-20 v-top pb2 normal ">Infinitiv:</th>
          <td className="w-80 v-top pb2 b dark-gray">huh</td>
        </tr>
        <tr>
          <th className="w-20 v-top pb2 normal ">Vzory:</th>
          <td className="w-80 v-top pb2 b dark-gray">
            <ul className="list pl0 mv0">
              <li><a className="link underline-hover black" href="#">dub</a></li>
              <li><a className="link underline-hover black" href="#">stroj</a></li>
              <li><a className="link underline-hover black" href="#">chlap</a></li>
            </ul>
          </td>
        </tr>
      </table>
    );
  }
}

export default AnalysisData;