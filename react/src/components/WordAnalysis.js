import React, {Component} from 'react';
import ReactTooltip from 'react-tooltip';
// import Pattern from './Pattern';
import {MdArrowDropDown} from 'react-icons/lib/md';

class WordAnalysis extends Component {
  constructor(props) {
    super(props);

    this.state = {
      wordData: null,
      patternData: null,
      genderData: null
    }
    
    // this.handlePatternClick = this.handlePatternClick.bind(this);
    this.handlePatternChange = this.handlePatternChange.bind(this);
    this.handleGenderChange = this.handleGenderChange.bind(this);
  }
  componentWillReceiveProps(nextProps) {
    if (nextProps.word !== null) {
      let wordData = nextProps.word.getData();
      let patternData = nextProps.patternData;
      let genderData = nextProps.genderData;

      this.setState({
        wordData: wordData,
        patternData: patternData,
        genderData: genderData
      })
    }
  }
  // handlePatternClick(selectedPattern) {
  //   let currentlyselectedPattern = this.state.selectedPattern;

  //   if (currentlyselectedPattern !== null) {
  //     currentlyselectedPattern.deselect();
  //   }

  //   this.setState({
  //     selectedPattern: selectedPattern
  //   });

  //   this.props.onPatternSelect(selectedPattern);
  // }
  handlePatternChange(event) {
    let patternData = this.state.wordData.patterns[event.target.value];


    this.setState({
      patternData: patternData
    })
    
    this.props.onPatternSelect(patternData);
  }
  handleGenderChange(event) {
    let genderData = this.state.patternData.genders[event.target.value];

    this.setState({
      genderData: genderData
    })

    this.props.onGenderSelect(genderData);
  }

  render() {
    const wordData = this.state.wordData;
    const patternData = this.state.patternData;

    if (wordData !== null) {;
      const patterns = wordData.patterns;
      const genders = patternData.genders;
    
      return (
        <div className={"WordAnalysis" + (this.props.isLoading ? " is-loading" : "")}>
          <table className="w-100 collapse tl mt4">
            <tbody>
              <tr className="">
                <th className=" v-top pv1 normal">Vzory:</th>
                <td className="w-100 pl2 pv0 v-top b">
                  <label className="Select db">
                    <select className="pv1 pl2 pr3 b" onChange={this.handlePatternChange}>
                      {patterns.map((item, index) => (
                        <option key={index} value={index}>
                          {item.pattern}
                        </option>
                      ))}
                    </select>
                    <MdArrowDropDown className="icon" />
                  </label>
                  {/*<ul className="list pl0 mv0 overflow-y-auto">
                    {patterns.map((item, index) => (
                      <li key={index}>
                        <Pattern 
                          className="Pattern ph2 pv1"
                          onClick={(selectedPattern) => {
                            this.handlePatternClick(selectedPattern);
                          }}
                          data = {item}
                        >{item.pattern}</Pattern>
                      </li>
                    ))}
                  </ul>*/}
                  <ReactTooltip class="Tooltip" effect="solid"/>
                </td>
              </tr>
              <tr className="">
                <th className=" v-top pv1 normal">Infinitiv:</th>
                <td className="w-100 pl3 v-top pv1 b">{ patternData.infinitive }</td>
              </tr>
              <tr className="">
                <th className="nowrap v-top pv1 normal">Slovný druh:</th>
                <td className="w-100 pl3 v-top pv1 b">{ patternData.wordClass }</td>
              </tr>
              <tr className="">
                <th className=" v-top pv1 normal">Rod:</th>
                <td className="w-100 pl2 pv0 v-top b">
                  <label className="Select db">
                    <select className="pv1 pl2 pr3 b" onChange={this.handleGenderChange}>
                      {genders.map((item, index) => (
                        <option key={index} value={index}>
                          {item.grammaticalGender}
                        </option>
                      ))}
                    </select>
                    <MdArrowDropDown className="icon" />
                  </label>
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
    return null;
  }
}

export default WordAnalysis;