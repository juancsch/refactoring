const Writer = require('./services/Writer')
const Mailer = require('./services/Mailer')
const Sms = require('./services/Sms')

let log
let mail
let sms

module.exports = {
	LOG: 0,
	WARNING: 1,
	CRITICAL: 2,
	log (type = '', message = '') {
		switch (type) {
		case this.LOG:
			log = new Writer()
			log.writeToFile(message)
			break
		case this.WARNING:
			log = new Writer()
			log.writeToFile(message)
			mail = new Mailer()
			mail.sendToSysadmin(message)
			break
		case this.CRITICAL:
			log = new Writer()
			log.writeToFile(message)
			mail = new Mailer()
			mail.sendToSysadmin(message)
			sms = new Sms()
			sms.sendToSysadmin(message)
			break
		}
	}
}
