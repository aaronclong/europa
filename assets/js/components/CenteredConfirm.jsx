import { Component, PropTypes } from 'react'

export default  class CenteredConfirm extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }
  renderMsg(){
    if (this.props.message) {
      return (
        <div>
          <span style={this.props.messageStyle || {}}>{this.props.message}</span>
        </div>
      );
    }
  }
  render(){
    return (
      <div className="generic-sidebar-delete-item">
        {this.renderMsg()}
        <div>
          <div className="button btn-confirm"
               style={this.props.confirmButtonStyle}
               onClick={this.props.onConfirm}>
            {this.props.confirmButtonText}
          </div>
          <div className="button btn-cancel"
               style={{background: "#ed718e"}}
               onClick={this.props.onCancel}>
            Cancel
          </div>
        </div>
      </div>
    );
  }
}

CenteredConfirm.contextTypes = {
  actions: React.PropTypes.object,
  userInfo: React.PropTypes.object,
  csfrToken: React.PropTypes.string,
};

CenteredConfirm.propTypes = {
  message: React.PropTypes.string,
  confirmButtonText:  React.PropTypes.string,
  confirmButtonStyle: React.PropTypes.string,
  onConfirm: React.PropTypes.func.isRequired,
  onCancel: React.PropTypes.func.isRequired
};

CenterdConfrim.defaultProps = {
  message: "Are you sure?",
  confirmButtonStyle: "Continue"
};



