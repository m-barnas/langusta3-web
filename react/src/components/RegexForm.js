import React, { Component } from 'react';
import {MdRefresh, MdInfoOutline, MdClose} from 'react-icons/lib/md';
import ReactTooltip from 'react-tooltip';
import { getWordClasses, getGrammaticalGenders, getNumbers, getGrammaticalCases } from '../util/enums';
import { fetchAllPatterns } from '../util/api';
import Select from './Select';
import Modal from 'react-modal';

export default class RegexForm extends Component {
  constructor(props) {
    super(props);

    this.state = {
      isModalOpen: false,
      value: "%a",
      wordClass: "",
      pattern: "",
      grammaticalGender: "",
      number: "",
      grammaticalCase: "",
      wordClasses: getWordClasses(),
      grammaticalGenders: getGrammaticalGenders(),
      grammaticalCases: getGrammaticalCases(),
      numbers: getNumbers()
    }

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }
  componentDidMount() {
    fetchAllPatterns().then((data) => {
      this.setState({
        patterns: data
      })
    })
  }
  handleChange(event) {
    this.setState({
      value: event.target.value
    });
  }
  handleSubmit(event) {
    event.preventDefault();

    // keys ['pattern', 'word-class', 'gender', 'number', 'grammatical-case']
    let filters = {
      'pattern': this.state.pattern,
      'word-class': this.state.wordClass,
      'gender': this.state.grammaticalGender,
      'number': this.state.number,
      'grammatical-case': this.state.grammaticalCase 
    }

    this.props.onSubmit(this.state.value, filters);
  }

  handleModalOpen = () => this.setState({isModalOpen: true})

  handleModalClose = () => this.setState({isModalOpen: false})

  render() {
    const tooltipContent = '<table class="collapse"><tbody>' +
      '<tr>' +
        '<th class="pr3">%</th>' +
        '<td>0, 1 alebo viacero znakov</td>' +
      '</tr>' +
      '<tr>' +
        '<th class="pr3">_</th>' +
        '<td>1 znak</td>' +
      '</tr>' +
    '</tbody></table>';
  
    return (
      <form className="" onSubmit={this.handleSubmit}>
        <div className="flex mb3">
          <div className="flex-auto">
            <label className="InputGroup flex">
              <input className={"flex-auto FormControl RegexInput code" + (this.props.isLoading ? " is-Loading" : "")}
              type="text" placeholder="%a" required data-tip={tooltipContent}
              value={this.state.value} onChange={this.handleChange}
              disabled={this.props.isLoading} pattern="([^\W\d]|%|[Á-ž])+"/>
              <a className="InputGroup-btn Button nowrap inline-flex items-center" type="button"
              onClick={this.handleModalOpen}>
                <MdInfoOutline className="dib mr1" />
                <span>Nápoveda</span>
              </a>
            </label>
          </div>
          <button className={"Button Button--primary ml3 nowrap" + (this.props.isLoading ? " is-loading" : "")} 
          type="submit" disabled={this.props.isLoading}>
            <MdRefresh className="Button-icon" /> Search
          </button>
        </div>

        <div className="dt-row">
          <label className="dtc pv1-ns pr3 nowrap" htmlFor="wordClass">Slovný druh:</label>
          <div className="dtc w-50-ns pr2-ns">
            <Select items={this.state.wordClasses} id="wordClass" onChange={(value) => {
             this.setState({wordClass: value})}
            } />
          </div>

          <label className="dtc pv1-ns pl2-ns pr3" htmlFor="pattern">Vzor:</label>
          <div className="dtc w-50-ns">
            <Select items={this.state.patterns} id="pattern" onChange={(value) => {
              this.setState({pattern: value})}
             } />
          </div>
        </div>

        <div className="dt-row">
          <label className="dtc pv1-ns pr3" htmlFor="grammaticalGender">Rod :</label>
          <div className="dtc w-50-ns pr2-ns">
            <Select items={this.state.grammaticalGenders} id="grammaticalGender" onChange={(value) => {
             this.setState({grammaticalGender: value})}
            } />
          </div>

          <label className="dtc pv1-ns pl2-ns pr3" htmlFor="number">Rod:</label>
          <div className="dtc w-50-ns">
            <Select items={this.state.numbers} id="number" onChange={(value) => {
              this.setState({number: value})}
             } />
          </div>
        </div>

        <div className="dt-row mt">
          <label className="dtc pv1-ns pr3" htmlFor="grammaticalCase">Pád:</label>
          <div className="dtc w-50-ns pr2-ns">
            <Select items={this.state.grammaticalCases} id="grammaticalCase" onChange={(value) => {
             this.setState({grammaticalCase: value})}
            } />
          </div>
        </div>
        <ReactTooltip class="Tooltip" effect="solid" html={true}/>

        <Modal
          isOpen={this.state.isModalOpen}
          onAfterOpen={this.handleModalOpen}
          onRequestClose={this.handleModalClose}
          contentLabel="Example Modal"
          className="Modal"
          overlayClassName="ModalOverlay"
        >
          <header className="cf ph4 pt4 pb2 bb b--black-10">
            <h2 className="fl mv0">Nápoveda</h2>
            <button className="Modal-close fr" type="button" onClick={this.handleModalClose}>
              <MdClose />
              <span className="clip">Zavrieť</span>
            </button>
          </header>
          
          <div className="ph4 pt2 pb4">
            <p>Môžete používať 2 špeciálne znaky:</p>
            <table className="collapse">
              <tbody>
                <tr>
                  <th className="ph3 b">%</th>
                  <td>reprezentuje 0, 1 alebo viacero znakov</td>
                </tr>
                <tr>
                  <th className="ph3 b">_</th>
                  <td>reprezentuje 1 znak</td>
                </tr>
              </tbody>
            </table>
            <h3 className="mt4 mb2">Príklady</h3>
            <table className="collapse">
              <thead>
                <tr>
                  <th className="pl3 pr3 pv1 tl">Výraz</th>
                  <th className="pr3 pv1 tl">Význam</th>
                  <th className="pr3 pv1 tl">Slová</th>
                </tr>
              </thead>
              <tbody>
                <tr className="striped--near-white">
                  <th className="pr3 pl3 pv1 tl v-top">a%</th>
                  <td className="pr3 pv1 v-top">slová, ktoré začínajú na písmeno <span className="b">a</span></td>
                  <td className="pv1 pr3 v-top">advokátka, asfaltka, autoškola</td>
                </tr>
                <tr className="striped--near-white">
                  <th className="pr3 pl3 pv1 tl v-top">%á</th>
                  <td className="pr3 pv1 v-top">slová, ktoré končia na písmeno <span className="b">á</span></td>
                  <td className="pv1 pr3 v-top">jednoznačná, vděčná, aranžmá</td>
                </tr>
                <tr className="striped--near-white">
                  <th className="pr3 pl3 pv1 tl v-top">%od%</th>
                  <td className="pr3 pv1 v-top">slová, ktoré obsahujú výraz <span className="b">od</span></td>
                  <td className="pv1 pr3 v-top">dodatečný, odpovědným, svobodnému</td>
                </tr>
                <tr className="striped--near-white">
                  <th className="pr3 pl3 pv1 tl v-top">_r%</th>
                  <td className="pr3 pv1 v-top">slová, ktoré majú písmeno <span className="b">r</span> na 2. pozícií</td>
                  <td className="pv1 pr3 v-top">hromadným, prázdné, krypta</td>
                </tr>
                <tr className="striped--near-white">
                  <th className="pr3 pl3 pv1 tl v-top">_r%</th>
                  <td className="pr3 pv1 v-top">slová, ktoré začínajú písmenom <span className="b">a</span> a majú aspoň 3 písmená</td>
                  <td className="pv1 pr3 v-top">analogový, akciová, apartmá</td>
                </tr>
                <tr className="striped--near-white">
                  <th className="pr3 pl3 pv1 tl v-top">a%o</th>
                  <td className="pr3 pv1 v-top">slová, ktoré začínajú písmenom <span className="b">a</span> a končia na písmeno <span className="b">o</span></td>
                  <td className="pv1 pr3 v-top">autíčko, avízo, avokádo</td>
                </tr>
              </tbody>
            </table>
          </div>
        </Modal>
      </form>
    )
  }
}